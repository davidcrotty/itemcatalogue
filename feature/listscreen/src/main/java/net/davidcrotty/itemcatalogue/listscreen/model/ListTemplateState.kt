package net.davidcrotty.itemcatalogue.listscreen.model

data class ListTemplateState(val feedItems: List<FeedItem>, val loadingState: LoadingState, val isInitialFetch: Boolean = false)

sealed class LoadingState {
    object CanLoadMore: LoadingState()
    object Retry: LoadingState()
}