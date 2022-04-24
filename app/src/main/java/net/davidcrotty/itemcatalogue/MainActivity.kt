package net.davidcrotty.itemcatalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.squareup.moshi.Moshi
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import net.davidcrotty.itemcatalogue.di.DndCatalogueAppGraph
import net.davidcrotty.itemcatalogue.di.ItemScreenGraphImpl
import net.davidcrotty.itemcatalogue.technology.navigation.NavigatorImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val itemFactory = applicationContext.applicationContext as DndCatalogueAppGraph

        setContent {
            val controller = rememberNavController()
            val navigator = NavigatorImpl(controller)
            ComposeWrapper(controller, ItemScreenGraphImpl(
                itemFactory.remoteAPIFactory().getInstance()
            )) {
                 navigator.navigate(it)
            }
        }
    }
}

interface RemoteItemAPIFactory {
    fun getInstance(): ItemAPI
}

// TODO could decouple this to a technology layer
class RemoteItemAPIFactoryImpl(private val moshi: Moshi,
                               private val okHttp: OkHttpClient,
                               private val baseUrl: String) : RemoteItemAPIFactory {

    private val itemAPI: ItemAPI by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttp)
            .build()
            .create(ItemAPI::class.java)
    }

    override fun getInstance(): ItemAPI {
        return itemAPI
    }
}