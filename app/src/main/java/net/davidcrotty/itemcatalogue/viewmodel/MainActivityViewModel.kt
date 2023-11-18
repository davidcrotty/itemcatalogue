package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.items.model.PreloadStatus
import net.davidcrotty.itemcatalogue.items.usecase.PreloadUseCase
import net.davidcrotty.itemcatalogue.model.ApplicationLoadState
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val preloadUseCase: PreloadUseCase) : ViewModel() {

    val launchErrorDialogShown
        get() = _launchErrorDialogShown
    private var applicationLoadState: ApplicationLoadState = ApplicationLoadState.Loading
    private val _launchErrorDialogShown = MutableStateFlow(false)

    fun preloadApplication() {
        viewModelScope.launch {
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
    }

    fun shouldKeepSplashOnScreen(): Boolean {
        return applicationLoadState is ApplicationLoadState.Loading
    }
}