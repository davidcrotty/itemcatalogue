package net.davidcrotty.itemcatalogue.viewmodel

import net.davidcrotty.itemcatalogue.model.ApplicationLoadState
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainActivityViewModelTest {

    @Test
    fun `test preloading application success`() {
        val sut = MainActivityViewModel()

        sut.preloadApplication()

        assertEquals(ApplicationLoadState.Success, sut.applicationLoadState)
    }
}