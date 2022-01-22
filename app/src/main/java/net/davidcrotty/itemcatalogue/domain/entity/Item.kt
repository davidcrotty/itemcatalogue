package net.davidcrotty.itemcatalogue.domain.entity

import net.davidcrotty.itemcatalogue.domain.model.ID

class Item(val id: ID, val url: String, val type: String, val title: String, val description: String)