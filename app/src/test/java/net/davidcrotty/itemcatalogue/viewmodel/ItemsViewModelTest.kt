package net.davidcrotty.itemcatalogue.viewmodel

import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineScheduler
import net.davidcrotty.itemcatalogue.helpers.CoroutineTest
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.items.usecase.GetFeedUsecase
import net.davidcrotty.itemcatalogue.model.FeedItem
import net.davidcrotty.itemcatalogue.model.ListTemplateState
import net.davidcrotty.itemcatalogue.model.LoadingState
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class ItemsViewModelTest : CoroutineTest {

    override var testScheduler = TestCoroutineScheduler()

    @Test
    fun when_performing_initial_fetch() {
        // given a list that hasn't been rendered yet
        val sut = ListTemplateViewModel(
            mockk {
                coEvery { getFeed() } returns ItemRepository.ItemStatus.Available(emptyList())
            }
        )

        // when fetching list
        sut.fetchItems()
        testScheduler.advanceUntilIdle()
        val state = sut.listState.value

        // then should only perform one fetch
        assertEquals(false, state.isInitialFetch)
    }

    @Test
    fun when_fetching_items() = runBlocking {
        // Given a valid item list

        val itemList = ItemRepository.ItemStatus.Available(listOf(
            Item(
                id = ID("id"),
                url = "url",
                type = "type",
                title = "title",
                description = "description"
            )
        ))
        val sut = ListTemplateViewModel(
            mockk {
                coEvery { getFeed() } returns itemList
            }
        )

        // When fetching items
        sut.fetchItems()
        testScheduler.advanceUntilIdle()

        // Then should render item
        val state = sut.listState.value.feedItems
        val expected = listOf(
            FeedItem(
                url = "url",
                type = "type",
                title = "title",
                description = "description"
            )
        )
        assertEquals(expected, state)
    }

    @Test
    fun `when fetching items with recoverable error`() {
        val getFeedUsecase: GetFeedUsecase = mockk {
            coEvery { getFeed() } returns ItemRepository.ItemStatus.RecoverableError
        }
        val sut = ListTemplateViewModel(
            getFeedUsecase = getFeedUsecase
        )

        sut.fetchItems()
        testScheduler.advanceUntilIdle()

        // TODO test existing items not lost
        val result = sut.listState.value
        val expected = ListTemplateState(
            feedItems = emptyList(),
            loadingState = LoadingState.Retry,
            isInitialFetch = false
        )
        assertEquals(expected, result)
    }
}