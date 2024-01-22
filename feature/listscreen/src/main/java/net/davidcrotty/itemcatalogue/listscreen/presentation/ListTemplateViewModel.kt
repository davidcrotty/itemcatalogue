package net.davidcrotty.itemcatalogue.listscreen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.items.usecase.GetFeedUsecase
import net.davidcrotty.itemcatalogue.listscreen.model.FeedItem
import net.davidcrotty.itemcatalogue.listscreen.model.ListTemplateState
import net.davidcrotty.itemcatalogue.listscreen.model.LoadingState
import javax.inject.Inject

@HiltViewModel
class ListTemplateViewModel @Inject constructor(
    private val getFeedUsecase: GetFeedUsecase
) : ViewModel(), ListTemplateContract {

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
                        type = entity.type,
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