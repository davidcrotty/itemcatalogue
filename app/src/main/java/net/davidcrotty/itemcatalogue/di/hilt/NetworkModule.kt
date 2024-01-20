package net.davidcrotty.itemcatalogue.di.hilt

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.davidcrotty.itemcatalogue.BuildConfig
import net.davidcrotty.itemcatalogue.R
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import net.davidcrotty.itemcatalogue.data.item.api.auth.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideItemAPI(okHttpClient: OkHttpClient, moshi: Moshi): ItemAPI {
        // log interceptor
        return Retrofit.Builder()
            .baseUrl("https://dnd-api-a4vdcpxg.uc.gateway.dev/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
            .create(ItemAPI::class.java)
    }

    @Provides
    fun provideOkhttpClient(@ApplicationContext context: Context): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            clientBuilder.addInterceptor(loggingInterceptor)
        }

        clientBuilder.addInterceptor(
            AuthInterceptor(context.getString(R.string.dnd_tools_api_key))
        )

        return clientBuilder.build()
    }

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }
}