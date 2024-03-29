@file:OptIn(ExperimentalCoroutinesApi::class)

package net.davidcrotty.itemcatalogue.detailscreen.presentation

import androidx.lifecycle.SavedStateHandle
import fr.xgouchet.elmyr.Forge
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScheduler
import net.davidcrotty.itemcatalogue.core.unittest.CoroutineTest
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.items.usecase.GetItemUsecase
import net.davidcrotty.itemcatalogue.detailscreen.model.ImageResult
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemDetail
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemDetailState
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemIDStatus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ItemDetailViewModelTest : CoroutineTest {

    override var testScheduler = TestCoroutineScheduler()
    private val forge = Forge()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when fetching item detail with valid image`() {
        // Given a viewmodel
        // And valid item detail
        val itemID = forge.aString()
        val item = Item(
            id = ID(itemID),
            url = forge.aString(),
            type = forge.aString(),
            title = forge.aString(),
            description = forge.aString(),
            subType = forge.aString(),
            element = forge.aString()
        )

        val itemDetailUsecaseMock = mockk<GetItemUsecase> {
            coEvery { execute(itemID) } returns ItemRepository.ItemStatus.Available(
                item
            )
        }
        val handle = mockk<SavedStateHandle> {
            every { get<String>("itemId") } returns itemID
        }
        val sut = ItemDetailViewModel(itemDetailUsecaseMock, handle)

        // When fetching an item detail
        sut.renderItemDetail()
        testScheduler.advanceUntilIdle()

        // Then state should contain a valid item detail
        val state = sut.itemDetailState.value
        val expected = ItemDetail(
            title = item.title,
            type = item.subType,
            description = item.description,
            image = ImageResult.Image(item.url),
            element = item.element
        )
        assertEquals(expected, state.itemDetail)
        assertEquals(false, state.isLoading)
    }

    @Test
    fun `when fetching item detail without valid image`() {
        // Given a viewmodel
        // And valid item detail without a valid image
        val itemID = forge.aString()
        val item = Item(
            id = ID(itemID),
            url = "",
            type = forge.aString(),
            title = forge.aString(),
            description = forge.aString(),
            subType = forge.aString(),
            element = forge.aString()
        )

        val itemDetailUsecaseMock = mockk<GetItemUsecase> {
            coEvery { execute(itemID) } returns ItemRepository.ItemStatus.Available(
                item
            )
        }

        val handle = mockk<SavedStateHandle> {
            every { get<String>("itemId") } returns itemID
        }
        val sut = ItemDetailViewModel(itemDetailUsecaseMock, handle)

        // When fetching an item detail
        sut.renderItemDetail()
        testScheduler.advanceUntilIdle()

        // Then state should contain a valid item detail
        val state = sut.itemDetailState.value
        val expected = ItemDetail(
            title = item.title,
            type = item.subType,
            description = item.description,
            image = ImageResult.Unavailable,
            element = item.element
        )
        assertEquals(expected, state.itemDetail)
        assertEquals(false, state.isLoading)
    }

    @Test
    fun `when fetching item detail error`() {
        // given item viewmodel
        val itemID = forge.aString()
        val itemDetailUsecaseMock = mockk<GetItemUsecase> {
            coEvery { execute(itemID) } returns ItemRepository.ItemStatus.Unavailable
        }

        val handle = mockk<SavedStateHandle> {
            every { get<String>("itemId") } returns itemID
        }
        val sut = ItemDetailViewModel(itemDetailUsecaseMock, handle)

        // When fetching an item detail
        sut.renderItemDetail()
        testScheduler.advanceUntilIdle()

        // Then state should contain information of error
        val state = sut.itemDetailState.value
        val expected = ItemDetailState(
            hasError = true,
            isLoading = false
        )
        assertEquals(expected, state)
        assertEquals(false, state.isLoading)
    }

}