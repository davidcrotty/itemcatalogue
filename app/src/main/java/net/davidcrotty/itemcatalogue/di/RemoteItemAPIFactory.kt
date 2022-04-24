package net.davidcrotty.itemcatalogue.di

import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI

interface RemoteItemAPIFactory {
    fun getInstance(): ItemAPI
}