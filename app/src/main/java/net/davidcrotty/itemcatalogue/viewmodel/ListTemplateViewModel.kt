package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.items.usecase.GetFeedUsecase
import net.davidcrotty.itemcatalogue.model.FeedItem
import net.davidcrotty.itemcatalogue.model.ListTemplateState
import net.davidcrotty.itemcatalogue.model.LoadingState
import javax.inject.Inject

@HiltViewModel
class ListTemplateViewModel @Inject constructor(
    private val getFeedUsecase: GetFeedUsecase
) : ViewModel() {

    // TODO challenge why not emit this as an alltogether ui state? Yes, means less args passed around (clean code varadic args)
    val listState: StateFlow<ListTemplateState>
        get() = _items

    private var initialPresentation = true
    private val _items = MutableStateFlow(
        ListTemplateState(
            emptyList(),
            LoadingState.CanLoadMore,
            initialPresentation
        )
    )

    fun fetchItems() {
        initialPresentation = false
        viewModelScope.launch {
            // keep track of next set of models, each invoke picks up next set from returned

            // if a 4xx response received, throw NotFoundException, state gets changed
            val fetchResult = getFeedUsecase.getFeed()
            if (fetchResult is ItemRepository.ItemListStatus.Available) {
                val feedModels = fetchResult.items.map { entity ->
                    FeedItem(
                        id = entity.id.value,
                        url = entity.url,
                        type = entity.type,
                        title = entity.title,
                        description = entity.description
                    )
                }

                _items.emit(
                    ListTemplateState(
                        feedModels,
                        LoadingState.CanLoadMore,
                        initialPresentation
                    )
                )
            } else if (fetchResult is ItemRepository.ItemListStatus.RecoverableError) {
                _items.emit(
                    ListTemplateState(
                        feedItems = listState.value.feedItems,
                        loadingState = LoadingState.Retry,
                        initialPresentation
                    )
                )
            }
        }
    }
}