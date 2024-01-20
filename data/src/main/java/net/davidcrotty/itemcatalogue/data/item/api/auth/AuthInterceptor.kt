package net.davidcrotty.itemcatalogue.data.item.api.auth

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val apiKey: String = "") : Interceptor {

    private val HEADER_API_KEY = "Authorization"
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val hb = original.headers().newBuilder()
        hb.add(HEADER_API_KEY, "Bearer $apiKey")
        return chain.proceed(original.newBuilder().headers(hb.build()).build())
    }
}