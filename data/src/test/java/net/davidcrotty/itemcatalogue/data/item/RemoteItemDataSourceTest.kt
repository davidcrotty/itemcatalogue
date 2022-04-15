package net.davidcrotty.itemcatalogue.data.item

import com.squareup.moshi.Moshi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import net.davidcrotty.itemcatalogue.data.item.dto.technology.ItemDTO
import net.davidcrotty.itemcatalogue.helpers.RequestRecorder
import okhttp3.OkHttpClient
import okreplay.*
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File


@OptIn(ExperimentalCoroutinesApi::class)
internal class RemoteItemDataSourceTest {

    private val testInterceptor = OkReplayInterceptor()

    private val config = OkReplayConfig.Builder()
        .tapeRoot(File("src/test/resources/remote_item_api"))
        .defaultMode(TapeMode.READ_ONLY)
        .interceptor(testInterceptor)
        .build()

    @get:Rule
    val recorder = RecorderRule(config)

    @Test
    @OkReplay
    fun `when calling api`() {
        // given an api returns a valid list of items
        val moshi = Moshi.Builder().build()
        val okHttp = OkHttpClient.Builder().addInterceptor(testInterceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://us-central1-dnd-tools-cb5b7.cloudfunctions.net/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttp)
            .build()
        val sut = RemoteItemDataSource(
            retrofit.create(ItemAPI::class.java)
        )

        // when calling the api
        runBlocking {
            val result = sut.fetchAfter("1")
        }

        // Then should provide list of data items
    }
}