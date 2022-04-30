package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.viewmodel.ListTemplateViewModel

interface ItemScreenGraph {
    fun itemViewModel(): ListTemplateViewModel
}