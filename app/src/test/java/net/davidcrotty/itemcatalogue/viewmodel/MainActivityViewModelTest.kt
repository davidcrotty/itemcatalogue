package net.davidcrotty.itemcatalogue.viewmodel

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScheduler
import net.davidcrotty.itemcatalogue.core.unittest.CoroutineTest
import net.davidcrotty.itemcatalogue.items.model.PreloadStatus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainActivityViewModelTest : net.davidcrotty.itemcatalogue.core.unittest.CoroutineTest {

    override var testScheduler: TestCoroutineScheduler = TestCoroutineScheduler()

    @Test
    fun `test preloading application success`() {
        val sut = MainActivityViewModel(
            preloadUseCase = mockk {
                coEvery { execute() } returns PreloadStatus.Loaded
            }
        )

        sut.preloadApplication()
        testScheduler.advanceUntilIdle()

        assertEquals(false, sut.shouldKeepSplashOnScreen())
        assertEquals(false, sut.launchErrorDialogShown.value)
    }

    @Test
    fun `test preloading application failure`() {
        val sut = MainActivityViewModel(
            preloadUseCase = mockk {
                coEvery { execute() } returns PreloadStatus.Error
            }
        )

        sut.preloadApplication()
        testScheduler.advanceUntilIdle()

        assertEquals(false, sut.shouldKeepSplashOnScreen())
        assertEquals(true, sut.launchErrorDialogShown.value)
    }

}