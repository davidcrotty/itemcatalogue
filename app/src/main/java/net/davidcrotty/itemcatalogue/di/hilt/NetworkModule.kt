package net.davidcrotty.itemcatalogue.di.hilt

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Named("apiKey")
    fun provideApiKey(@ApplicationContext context: Context): String = context.getString(R.string.dnd_tools_api_key)

    @Provides
    fun provideItemAPI(okHttpClient: OkHttpClient, moshi: Moshi): ItemAPI {
        return Retrofit.Builder()
            .baseUrl("https://us-central1-dnd-tools-cb5b7.cloudfunctions.net/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
            .create(ItemAPI::class.java)
    }

    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }
}