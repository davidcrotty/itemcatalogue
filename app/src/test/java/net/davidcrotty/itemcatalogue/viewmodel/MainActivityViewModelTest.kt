package net.davidcrotty.itemcatalogue.viewmodel

import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineScheduler
import net.davidcrotty.itemcatalogue.helpers.CoroutineTest
import net.davidcrotty.itemcatalogue.helpers.TestCoroutineExtension
import net.davidcrotty.itemcatalogue.items.model.PreloadStatus
import net.davidcrotty.itemcatalogue.model.ApplicationLoadState
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
class MainActivityViewModelTest : CoroutineTest {

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