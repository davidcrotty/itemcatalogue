package net.davidcrotty.itemcatalogue.di

import com.squareup.moshi.Moshi
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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