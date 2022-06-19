package net.davidcrotty.itemcatalogue.model

data class ListTemplateState(val feedItems: List<FeedItem>, val loadingState: LoadingState)

sealed class LoadingState {
    object CanLoadMore: LoadingState()
    object NoContent: LoadingState()
    object Retry: LoadingState()
}