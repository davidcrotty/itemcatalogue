package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.items.usecase.GetItemUsecase
import net.davidcrotty.itemcatalogue.model.ImageResult
import net.davidcrotty.itemcatalogue.model.ItemDetail
import net.davidcrotty.itemcatalogue.model.ItemDetailState

class ItemDetailViewModel(private val getItemUsecase: GetItemUsecase) : ViewModel() {

    private val _itemDetailState = MutableStateFlow<ItemDetailState>(ItemDetailState())
    val itemDetailState: StateFlow<ItemDetailState> = _itemDetailState

    fun renderItemDetail(id: String) {
        viewModelScope.launch {
            when (val itemResult = getItemUsecase.execute(id)) {
                is ItemRepository.ItemStatus.Available -> {
                    val item = itemResult.item
                    val imageResult = resolveImageResult(item.url)
                    _itemDetailState.value = ItemDetailState(
                        isLoading = false,
                        itemDetail = ItemDetail(
                            title = item.title,
                            type = item.type,
                            image = imageResult,
                            description = item.description
                        )
                    )
                }
                is ItemRepository.ItemStatus.Unavailable -> {
                    _itemDetailState.value = ItemDetailState(
                        isLoading = false,
                        hasError = true
                    )
                }
            }
        }
    }

    private fun resolveImageResult(url: String): ImageResult {
        return if (url.isNullOrEmpty()) {
            ImageResult.Unavailable
        } else {
            ImageResult.Image(url)
        }
    }

}