package net.davidcrotty.itemcatalogue.technology

import net.davidcrotty.itemcatalogue.domain.entity.Item
import net.davidcrotty.itemcatalogue.domain.model.ID

class ItemMemoryDataSource : ItemDataSource {
    override fun fetchAfter(id: ID): List<Item> {
        return listOf( // TODO these should be DTOs
            Item(
                id = ID(1),
                url = "https://www.scabard.com/user/Pochibella/image/10e63a407bbd6066ddb5444369e942ee.jpg",
                type = "Weapon (sword)",
                title = "Acheron Blade",
                description = "The black blade of this sword is crafted from a mysterious arcane alloy. You gain a +1 bonus to attack and damage rolls made with this magic weapon. While the sword is on your person, you are immune to effects that turn undead."
            ),
            Item(
                id = ID(2),
                url = "https://media-waterdeep.cursecdn.com/avatars/thumbnails/8/305/1000/1000/636302782994996851.jpeg",
                type = "Weapon (battleaxe)",
                title = "Azuredge",
                description = "Forged by the archwizard Ahghairon, this intelligent battleaxe was crafted to defend Waterdeep. Its current wielder is a former member of Force Grey named Meloon Wardragon, but the weapon is searching for a new owner."
            )
        )
    }
}