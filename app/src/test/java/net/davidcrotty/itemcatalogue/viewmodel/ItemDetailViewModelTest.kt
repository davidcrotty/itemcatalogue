package net.davidcrotty.itemcatalogue.viewmodel

import fr.xgouchet.elmyr.Forge
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScheduler
import net.davidcrotty.itemcatalogue.helpers.CoroutineTest
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.items.usecase.GetItemUsecase
import net.davidcrotty.itemcatalogue.model.ImageResult
import net.davidcrotty.itemcatalogue.model.ItemDetail
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
            description = forge.aString()
        )

        val itemDetailUsecaseMock = mockk<GetItemUsecase> {
            coEvery { execute(itemID) } returns ItemRepository.ItemStatus.Available(
                item
            )
        }
        val sut = ItemDetailViewModel(itemDetailUsecaseMock)

        // When fetching an item detail
        sut.renderItemDetail(itemID)
        testScheduler.advanceUntilIdle()

        // Then state should contain a valid item detail
        val state = sut.itemDetailState.value
        val expected = ItemDetail(
            title = item.title,
            type = item.type,
            description = item.description,
            image = ImageResult.Image(item.url)
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
            description = forge.aString()
        )

        val itemDetailUsecaseMock = mockk<GetItemUsecase> {
            coEvery { execute(itemID) } returns ItemRepository.ItemStatus.Available(
                item
            )
        }
        val sut = ItemDetailViewModel(itemDetailUsecaseMock)

        // When fetching an item detail
        sut.renderItemDetail(itemID)
        testScheduler.advanceUntilIdle()

        // Then state should contain a valid item detail
        val state = sut.itemDetailState.value
        val expected = ItemDetail(
            title = item.title,
            type = item.type,
            description = item.description,
            image = ImageResult.Unavailable
        )
        assertEquals(expected, state.itemDetail)
        assertEquals(false, state.isLoading)
    }

    @Test
    fun `when fetching item detail error`() {
        TODO("Not implemented")
    }

}