package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import net.davidcrotty.itemcatalogue.items.model.PreloadStatus
import net.davidcrotty.itemcatalogue.items.usecase.PreloadUseCase
import net.davidcrotty.itemcatalogue.model.ApplicationLoadState

class MainActivityViewModel(private val preloadUseCase: PreloadUseCase) : ViewModel() {

    var applicationLoadState: ApplicationLoadState = ApplicationLoadState.Loading

    fun preloadApplication() {
        val status = preloadUseCase.execute()
        if (status is PreloadStatus.Loaded) {
            applicationLoadState = ApplicationLoadState.Success
        }
    }
}