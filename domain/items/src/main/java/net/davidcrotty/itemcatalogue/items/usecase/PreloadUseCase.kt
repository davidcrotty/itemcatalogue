package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.model.PreloadStatus

interface PreloadUseCase {
    fun execute(): PreloadStatus
}