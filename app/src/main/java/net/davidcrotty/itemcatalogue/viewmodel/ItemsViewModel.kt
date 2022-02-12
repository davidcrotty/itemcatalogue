package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.domain.ItemRepository
import net.davidcrotty.itemcatalogue.domain.entity.Item
import net.davidcrotty.itemcatalogue.domain.model.ID
import net.davidcrotty.itemcatalogue.domain.model.Query

class ItemsViewModel(private val itemRepository: ItemRepository) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())

    val items: Flow<List<Item>>
        get() = _items

    fun fetchItems(id: ID = ID(0)) {
//        viewModelScope.launch {
//            _items.emit(
//                itemRepository.getItems(Query(id))
//            )
//        }
    }
}