package net.davidcrotty.itemcatalogue.technology

import net.davidcrotty.itemcatalogue.domain.entity.Item
import net.davidcrotty.itemcatalogue.domain.model.ID

class ItemMemoryDataSource : ItemDataSource {
    override fun fetchAfter(id: ID): List<Item> {
        return listOf(
            Item(
                id = ID(1),
                url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
                type = "Type",
                title = "Title",
                description = "1"
            ),
            Item(
                id = ID(2),
                url = "https://pbs.twimg.com/media/Eg9TpoLU8AActiA?format=jpg&name=large",
                type = "Type",
                title = "Title",
                description = "2"
            )
        )
    }
}