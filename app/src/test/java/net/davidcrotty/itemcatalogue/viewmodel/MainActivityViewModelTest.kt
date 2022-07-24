package net.davidcrotty.itemcatalogue.viewmodel

import io.mockk.every
import io.mockk.mockk
import net.davidcrotty.itemcatalogue.items.model.PreloadStatus
import net.davidcrotty.itemcatalogue.model.ApplicationLoadState
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainActivityViewModelTest {

    @Test
    fun `test preloading application success`() {
        val sut = MainActivityViewModel(
            preloadUseCase = mockk {
                every { execute() } returns PreloadStatus.Loaded
            }
        )

        sut.preloadApplication()

        assertEquals(ApplicationLoadState.Success, sut.applicationLoadState)
    }
}