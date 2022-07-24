package net.davidcrotty.itemcatalogue.viewmodel

import io.mockk.every
import io.mockk.mockk
import net.davidcrotty.itemcatalogue.items.model.PreloadStatus
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

        assertEquals(false, sut.shouldKeepSplashOnScreen())
    }

    @Test
    fun `test preloading application failure`() {
        val sut = MainActivityViewModel(
            preloadUseCase = mockk {
                every { execute() } returns PreloadStatus.Error
            }
        )

        sut.preloadApplication()

        assertEquals(false, sut.shouldKeepSplashOnScreen())
        assertEquals(true, sut.launchErrorDialogShown.value)
    }

}