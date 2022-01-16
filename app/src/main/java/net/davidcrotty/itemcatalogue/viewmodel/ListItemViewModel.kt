package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.model.ItemModel

class ListItemViewModel : ViewModel() {

    // TODO perhaps add a state to this
    private val _items = MutableStateFlow<List<ItemModel>>(emptyList())

    val items: Flow<List<ItemModel>>
        get() = _items

    fun fetchItems() {
        viewModelScope.launch {
            _items.emit(
                listOf(
                    ItemModel(
                        url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
                        type = "Type",
                        title = "Title",
                        description = "1"
                    ),
                    ItemModel(
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