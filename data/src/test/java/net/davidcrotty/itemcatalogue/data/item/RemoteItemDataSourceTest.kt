package net.davidcrotty.itemcatalogue.data.item

import net.davidcrotty.itemcatalogue.data.item.api.ItemAPI
import net.davidcrotty.itemcatalogue.helpers.RequestRecorder
import okreplay.*
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import java.io.File


internal class RemoteItemDataSourceTest {

    private val testInterceptor = OkReplayInterceptor()

    private val requestRecorder = RequestRecorder()

    private val config = OkReplayConfig.Builder()
        .tapeRoot(File("src/test/resources"))
        .defaultMode(TapeMode.READ_ONLY)
        .interceptor(testInterceptor)
        .defaultMatchRule { recorded, _ ->
            requestRecorder.record(recorded)
            true
        }
        .build()

    @get:Rule
    val recorder = RecorderRule(config)

    @Test
    @OkReplay
    fun `when calling api`() {
        // given an api returns a valid list of items
        val retrofit = Retrofit.Builder()
            .baseUrl("https://us-central1-dnd-tools-cb5b7.cloudfunctions.net/")
            .build()
        val sut = RemoteItemDataSource(
            retrofit.create(ItemAPI::class.java)
        )

        // when calling the api
        val result = sut.fetchAfter("1")

        // Then should provide list of data items
    }
}