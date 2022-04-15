package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.items.data.ItemDataSource
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item

class ItemMemoryDataSource : ItemDataSource {
    override fun fetchAfter(id: String): List<Item> {
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
            ),
            Item(
                id = ID(3),
                url = "https://www.dndbeyond.com/avatars/thumbnails/7/132/315/315/636284712925694328.jpeg",
                type = "Weapon (axe)",
                title = "Berserker Axe",
                description = "You gain a +1 bonus to attack and damage rolls made with this magic weapon. In addition, while you are attuned to this weapon, your hit point maximum increases by 1 for each level you have attained"
            ),
            Item(
                id = ID(4),
                url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNA3zNfGOeW0lqr0K2Z21AbiusQYZTxXsoIiY5QtOCVZtJYVKywoMUlrVb8j_XDYSFn5c&usqp=CAU",
                type = "Weapon (greatsword)",
                title = "Blackrazor",
                description = "Hidden in the dungeon of White Plume Mountain, Blackrazor shines like a piece of night sky filled with stars. Its black scabbard is decorated with pieces of cut obsidian."
            ),
            Item(
                id = ID(5),
                url = "https://static1.thegamerimages.com/wordpress/wp-content/uploads/2020/01/Sword-of-Sharpness.jpg?q=50&fit=crop&w=1600&dpr=1.5",
                type = "Weapon (longsword)",
                title = "Blade of Avernus",
                description = "This longsword belonged to the angel Zariel before her fall from grace. Fashioned from celestial steel, it gives off a faint glow and hum. The weapon chooses who can attune to it and who can't. It desires a wielder who embodies bravery and heroism."
            ),
            Item(
                id = ID(6),
                url = "https://www.aidedd.org/dnd/images-om/dragon-slayer.jpg",
                type = "Weapon (dagger)",
                title = "Blade of Broken Mirrors",
                description = "A weapon of Tharizdun, this dagger is a piece of jagged stone whose blade is scribed with a maze-like pattern with no beginning or end."
            )
        )
    }
}