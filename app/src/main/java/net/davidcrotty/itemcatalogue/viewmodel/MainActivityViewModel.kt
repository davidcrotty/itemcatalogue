package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import net.davidcrotty.itemcatalogue.model.ApplicationLoadState

class MainActivityViewModel : ViewModel() {

    var applicationLoadState: ApplicationLoadState = ApplicationLoadState.Loading

    fun preloadApplication() {

    }
}