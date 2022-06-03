package net.davidcrotty.itemcatalogue.data.item

import com.squareup.moshi.Moshi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import net.davidcrotty.itemcatalogue.data.item.dto.pure.ItemDTO
import okhttp3.OkHttpClient
import okreplay.*
import org.junit.Assert.assertEquals
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
        // TODO consider limit on API (query 1, record result, make limit configurable)

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
        val result = runBlocking {
            sut.fetchAfter("1", 1)
        }

        // Then should provide list of data items
        val expected = listOf(
            ItemDTO(
                id = "624842bb3c93ea918aa9585c",
                type = "Weapon",
                subtype = "sword",
                caption = "damage combat",
                description = "The black blade of this sword is crafted from a mysterious arcane alloy. You gain a +1",
                thumbnail = "https://www.scabard.com/user/Pochibella/image/10e63a407bbd6066ddb5444369e942ee.jpg",
                detailImage = "https://static.wikia.nocookie.net/elderscrolls/images/3/38/NordicBattleaxe.png/revision/latest?cb=20130309120450"
            )
        )
        assertEquals(expected, result)
    }
}