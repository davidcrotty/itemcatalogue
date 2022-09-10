package net.davidcrotty.itemcatalogue.items.usecase

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.items.model.PreloadStatus
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class PreloadUseCaseImplTest {

    @Test
    fun `test when preloading content`() {
        // Given the feed resource is able to be loaded
        val itemRepo = mockk<ItemRepository> {
            coEvery { getItems() } returns ItemRepository.ItemStatus.Available(emptyList())
        }

        val sut = PreloadUseCaseImpl(
            itemRepo
        )

        // When preloading the content
        val result = runBlocking {
            sut.execute()
        }

        // Then result should be succesful
        assertTrue(result is PreloadStatus.Loaded)
    }

    @Test
    fun `test when preloading content fails with an unrecoverable error`() {
        // Given the feed resource is able NOT able to be loaded
        val itemRepo = mockk<ItemRepository> {
            coEvery { getItems() } returns ItemRepository.ItemStatus.UnrecoverableError
        }

        val sut = PreloadUseCaseImpl(
            itemRepo
        )

        // When preloading the content
        val result = runBlocking {
            sut.execute()
        }

        // Then result should not be successful
        assertTrue(result is PreloadStatus.Error)
    }

    @Test
    fun `test when preloading content fails with an recoverable error`() {
        // Given the feed resource is able NOT able to be loaded
        val itemRepo = mockk<ItemRepository> {
            coEvery { getItems() } returns ItemRepository.ItemStatus.RecoverableError
        }

        val sut = PreloadUseCaseImpl(
            itemRepo
        )

        // When preloading the content
        val result = runBlocking {
            sut.execute()
        }

        // Then result should not be successful
        assertTrue(result is PreloadStatus.Error)
    }
}