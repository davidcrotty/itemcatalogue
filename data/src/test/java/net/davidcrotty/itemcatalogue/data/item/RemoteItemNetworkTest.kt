package net.davidcrotty.itemcatalogue.data.item

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import net.davidcrotty.itemcatalogue.data.item.api.auth.AuthInterceptor
import net.davidcrotty.itemcatalogue.data.item.dto.pure.ItemDTO
import net.davidcrotty.itemcatalogue.data.item.exception.ContentFailedToFetch
import net.davidcrotty.itemcatalogue.data.item.exception.ContentNotFound
import okhttp3.OkHttpClient
import okreplay.*
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.io.IOException


internal class RemoteItemNetworkTest {

    private val testInterceptor = OkReplayInterceptor()

    private val config = OkReplayConfig.Builder()
        .tapeRoot(File("src/test/resources/remote_item_api"))
        .defaultMode(TapeMode.READ_ONLY)
        .interceptor(testInterceptor)
        .build()

    @get:Rule
    val recorder = RecorderRule(config)

    @Test(expected = ContentNotFound::class)
    @OkReplay
    fun `when server errors`() {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(testInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dnd-api-a4vdcpxg.uc.gateway.dev/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttp)
            .build()
        val sut = RemoteItemDataSourceImpl(
            retrofit.create(ItemAPI::class.java)
        )

        runBlocking {
            sut.fetchAfter(null, 1)
        }
    }

    @Test
    @OkReplay
    fun `when fetching initial items`() {
        // given an api returns a valid list of items
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(testInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dnd-api-a4vdcpxg.uc.gateway.dev/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttp)
            .build()
        val sut = RemoteItemDataSourceImpl(
            retrofit.create(ItemAPI::class.java)
        )

        // when calling the api
        val result = runBlocking {
            sut.fetchAfter(null, 1)
        }

        // Then should provide list of data items
        val expected = listOf(
            ItemDTO(
                id = "624842bb3c93ea918aa9585c",
                type = "Spell",
                subtype = "Conjuration cantrip",
                caption = "Acid Splash",
                description = "You hurl a bubble of acid. Choose one creature you can see within range, or choose two creatures you can see within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage.",
                thumbnail = "https://bg3.wiki/w/images/thumb/e/eb/Acid_Splash.webp/380px-Acid_Splash.webp.png",
                detailImage = "https://static.wikia.nocookie.net/elderscrolls/images/3/38/NordicBattleaxe.png/revision/latest?cb=20130309120450",
                damageType = "acid"
            )
        )
        assertEquals(expected, result)
    }

    @Test
    @OkReplay
    fun `when fetching subsequent items`() {
        // given an api returns a valid list of items
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(testInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dnd-api-a4vdcpxg.uc.gateway.dev/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttp)
            .build()
        val sut = RemoteItemDataSourceImpl(
            retrofit.create(ItemAPI::class.java)
        )

        // when calling the api
        val result = runBlocking {
            sut.fetchAfter("624842bb3c93ea918aa9585c", 1)
        }

        // Then should provide list of data items
        val expected = listOf(
            ItemDTO(
                id = "62595c094d73bccd99d1eebf",
                type = "Weapon",
                subtype = "sword",
                caption = "damage combat",
                description = "The black blade of this sword is crafted from a mysterious arcane alloy. You gain a +1",
                thumbnail = "https://www.scabard.com/user/Pochibella/image/10e63a407bbd6066ddb5444369e942ee.jpg",
                detailImage = "https://static.wikia.nocookie.net/elderscrolls/images/3/38/NordicBattleaxe.png/revision/latest?cb=20130309120450",
                damageType = ""
            )
        )

        assertEquals(expected, result)
    }
}