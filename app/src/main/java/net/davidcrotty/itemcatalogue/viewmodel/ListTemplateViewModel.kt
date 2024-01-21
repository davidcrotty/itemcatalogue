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
) : ViewModel(), ListTemplateContract {

    // TODO challenge why not emit this as an alltogether ui state? Yes, means less args passed around (clean code varadic args)
    override val listState: StateFlow<ListTemplateState>
        get() = _items

    private var initialPresentation = true
    private val _items = MutableStateFlow(
        ListTemplateState(
            emptyList(),
            LoadingState.CanLoadMore,
            initialPresentation
        )
    )

    override fun fetchItems() {
        initialPresentation = false
        viewModelScope.launch {
            val fetchResult = getFeedUsecase.getFeed()
            if (fetchResult is ItemRepository.ItemListStatus.Available) {
                val feedModels = fetchResult.items.map { entity ->
                    FeedItem(
                        id = entity.id.value,
                        url = entity.url,
                        subType = entity.subType,
                        title = entity.title,
                        description = entity.description,
                        element = entity.element
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