package net.davidcrotty.itemcatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import net.davidcrotty.itemcatalogue.items.entity.ID
import net.davidcrotty.itemcatalogue.items.entity.Item
import net.davidcrotty.itemcatalogue.items.repository.ItemRepository

class ItemsViewModel(
    private val itemRepository: ItemRepository) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())

    val items: Flow<List<Item>>
        get() = _items

    // TODO next session, Safely create an 'Item' into a view facing model, and keep the Domain Item in its own (decouple view from entity)
    fun fetchItems(id: ID = ID(0)) {
        viewModelScope.launch {
            _items.emit(
                itemRepository.getItems()
            )
        }
    }

    // usecase will fetch, contract provided by domain
    // repo will fetch, contract provided by domain
    // entity - provided by domain

    // app provides impl for uc:
    // fetchFeedItems -> repo

    // app provides impl for repo:
    // Repo keeps id of last item in list for fetch, next call uses that - else api call
    // repo also stores and fetches from its cache of prior items

    // other rules it may add would be setting an expiry on cache items and check expiry on cache items (on pull down to refresh or restart for example)

    // data module would contain gateways and impl for retrofit call

    // technologies ie: retrofit would provide their interface via their own module

    // Questions: Would a usecase impl sit inside a domain module or the feature? (My take: feature because it may depend on other technologies (ie will need at least delegating to)
}