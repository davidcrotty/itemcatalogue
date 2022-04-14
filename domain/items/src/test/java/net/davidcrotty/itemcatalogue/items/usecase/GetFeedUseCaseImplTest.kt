package net.davidcrotty.itemcatalogue.items.usecase

import org.junit.jupiter.api.Test

internal class GetFeedUseCaseImplTest {
    @Test
    fun `when retrieving an item feed`() {
        val sut = GetFeedUseCaseImpl()

        sut.getFeed()
    }
}