package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.domain.entity.Item

class ItemsViewModel : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())

    val items: Flow<List<Item>>
        get() = _items

    fun fetchItems() {
        viewModelScope.launch {
            _items.emit(
                emptyList()
            )
        }
    }
}