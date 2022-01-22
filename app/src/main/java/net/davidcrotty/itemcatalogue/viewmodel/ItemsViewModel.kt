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
                listOf(
                    Item(
                        url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
                        type = "Type",
                        title = "Title",
                        description = "1"
                    ),
                    Item(
                        url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
                        type = "Type",
                        title = "Title",
                        description = "2"
                    )
                )
            )
        }
    }
}