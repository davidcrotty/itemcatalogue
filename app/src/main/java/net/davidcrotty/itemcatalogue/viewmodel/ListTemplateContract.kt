package net.davidcrotty.itemcatalogue.viewmodel

import kotlinx.coroutines.flow.StateFlow
import net.davidcrotty.itemcatalogue.model.ListTemplateState

interface ListTemplateContract {
    val listState: StateFlow<ListTemplateState>
    fun fetchItems()
}