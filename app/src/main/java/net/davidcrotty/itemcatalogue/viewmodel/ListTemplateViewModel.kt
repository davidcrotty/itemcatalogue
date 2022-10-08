package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.items.usecase.GetFeedUsecase
import net.davidcrotty.itemcatalogue.model.FeedItem
import net.davidcrotty.itemcatalogue.model.ListTemplateState
import net.davidcrotty.itemcatalogue.model.LoadingState

class ListTemplateViewModel(
    private val getFeedUsecase: GetFeedUsecase
) : ViewModel() {

    // TODO challenge why not emit this as an alltogether ui state? Yes, means less args passed around (clean code varadic args)
    val listState: StateFlow<ListTemplateState>
        get() = _items

    private var initialPresentation = true
    private val _items = MutableStateFlow(ListTemplateState(emptyList(), LoadingState.CanLoadMore, initialPresentation))

    fun fetchItems() {
        initialPresentation = false
        viewModelScope.launch {
            // keep track of next set of models, each invoke picks up next set from returned

            // if a 4xx response received, throw NotFoundException, state gets changed
            val fetchResult = getFeedUsecase.getFeed()
            if (fetchResult is ItemRepository.ItemStatus.Available) {
                val feedModels = fetchResult.items.map { entity ->
                    FeedItem(
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
            } else if (fetchResult is ItemRepository.ItemStatus.RecoverableError) {
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

    // usecase will fetch, contract provided by domain
    // repo will fetch, contract provided by domain
    // entity - provided by domain

    // app provides impl for uc:
    // fetchFeedItems -> repo

    // app provides impl for repo:
    // Repo keeps id of last item in list for fetch, next call uses that - else api call
    // repo also stores and fetches from its cache of prior items

    // other rules it may add would be setting an expiry on cache items and check expiry on cache items (on pull down to refresh or restart for example)

    // data module would contain gateways and impl for retrofit call

    // technologies ie: retrofit would provide their interface via their own module

    // Questions: Would a usecase impl sit inside a domain module or the feature? (My take: feature because it may depend on other technologies (ie will need at least delegating to)
}