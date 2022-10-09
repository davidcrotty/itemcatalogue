package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.model.PreloadStatus
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

class PreloadUseCaseImpl(private val itemRepository: ItemRepository) : PreloadUseCase {
    override suspend fun execute(): PreloadStatus {
        if (itemRepository.getItems() is ItemRepository.ItemListStatus.Available) {
            return PreloadStatus.Loaded
        }
        return PreloadStatus.Error
    }
}