package net.davidcrotty.itemcatalogue.detailscreen.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository
import net.davidcrotty.itemcatalogue.items.usecase.GetItemUsecase
import net.davidcrotty.itemcatalogue.detailscreen.model.ImageResult
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemDetail
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemDetailState
import net.davidcrotty.itemcatalogue.detailscreen.model.ItemIDStatus
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(
    private val getItemUsecase: GetItemUsecase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), ItemDetailContract {

    private val id: ItemIDStatus by lazy {
        val itemID = savedStateHandle.get<String>("itemId")
        val status = if (itemID == null) {
            ItemIDStatus.Unavailable
        } else {
            ItemIDStatus.Available(itemID)
        }
        status
    }

    private val _itemDetailState = MutableStateFlow<ItemDetailState>(ItemDetailState())
    override val itemDetailState: StateFlow<ItemDetailState> = _itemDetailState

    override fun renderItemDetail() {
        viewModelScope.launch {
            val localId = this@ItemDetailViewModel.id
            if (localId is ItemIDStatus.Available) {
                when (val itemResult = getItemUsecase.execute(localId.value)) {
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
                        itemError()
                    }
                }
            } else {
                itemError()
            }
        }
    }

    private fun itemError() {
        _itemDetailState.value = ItemDetailState(
            isLoading = false,
            hasError = true
        )
    }

    private fun resolveImageResult(url: String): ImageResult {
        return if (url.isNullOrEmpty()) {
            ImageResult.Unavailable
        } else {
            ImageResult.Image(url)
        }
    }

}