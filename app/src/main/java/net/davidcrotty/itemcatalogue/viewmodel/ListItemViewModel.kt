package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import net.davidcrotty.itemcatalogue.model.ItemModel

class ListItemViewModel : ViewModel() {

    // TODO perhaps add a state to this
    private val _items = MutableStateFlow<List<ItemModel>>(emptyList())

    val items: Flow<List<ItemModel>>
        get() = _items

    fun fetchItems() {

    }
}