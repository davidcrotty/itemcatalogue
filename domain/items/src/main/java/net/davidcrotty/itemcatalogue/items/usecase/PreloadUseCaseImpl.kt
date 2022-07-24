package net.davidcrotty.itemcatalogue.items.usecase

import net.davidcrotty.itemcatalogue.items.model.PreloadStatus

class PreloadUseCaseImpl : PreloadUseCase {
    override fun execute(): PreloadStatus {
        return PreloadStatus.Loaded
    }
}