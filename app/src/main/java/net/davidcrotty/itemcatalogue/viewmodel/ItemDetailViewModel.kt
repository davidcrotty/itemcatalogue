package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.items.usecase.GetItemUsecase
import net.davidcrotty.itemcatalogue.model.ItemDetail
import net.davidcrotty.itemcatalogue.model.ItemDetailState

class ItemDetailViewModel(private val getItemUsecase: GetItemUsecase) : ViewModel() {

    private val _itemDetailState = MutableStateFlow<ItemDetailState>(ItemDetailState())
    val itemDetailState: StateFlow<ItemDetailState> = _itemDetailState

    fun renderItemDetail(id: String) {
        viewModelScope.launch {
            val itemResult = getItemUsecase.execute(id)

            when(itemResult) {
                is ItemRepository.ItemStatus.Available -> {
                    val item = itemResult.item
                    _itemDetailState.value = ItemDetailState(
                        isLoading = false,
                        itemDetail = ItemDetail(
                            title = item.title,
                            type = item.type,
                            image = item.url,
                            description = item.description
                        )
                    )
                }
                is ItemRepository.ItemStatus.Unavailable -> {
                    TODO("Not implemented")
                }
            }
        }
    }

}