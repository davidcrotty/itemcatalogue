package net.davidcrotty.itemcatalogue.listscreen.presentation

import kotlinx.coroutines.flow.StateFlow
import net.davidcrotty.itemcatalogue.listscreen.model.ListTemplateState

interface ListTemplateContract {
    val listState: StateFlow<ListTemplateState>
    fun fetchItems()
}