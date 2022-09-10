package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import net.davidcrotty.itemcatalogue.items.model.PreloadStatus
import net.davidcrotty.itemcatalogue.items.usecase.PreloadUseCase
import net.davidcrotty.itemcatalogue.model.ApplicationLoadState

class MainActivityViewModel(private val preloadUseCase: PreloadUseCase) : ViewModel() {

    var applicationLoadState: ApplicationLoadState = ApplicationLoadState.Loading
    val launchErrorDialogShown
        get() = _launchErrorDialogShown
    private val _launchErrorDialogShown = MutableStateFlow(false)

    fun preloadApplication() {
        when(preloadUseCase.execute()) {
            is PreloadStatus.Loaded -> {
                applicationLoadState = ApplicationLoadState.Success
            }
            is PreloadStatus.Error -> {
                _launchErrorDialogShown.value = true
                applicationLoadState = ApplicationLoadState.Failed
            }
        }
    }

    fun shouldKeepSplashOnScreen(): Boolean {
        return applicationLoadState is ApplicationLoadState.Loading
    }
}