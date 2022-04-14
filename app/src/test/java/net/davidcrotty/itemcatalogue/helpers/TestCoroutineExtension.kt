package net.davidcrotty.itemcatalogue.helpers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.extension.*

class TestCoroutineExtension : TestInstancePostProcessor, BeforeAllCallback,
    AfterAllCallback {

    val testScheduler = TestCoroutineScheduler()
    private val testDispatcher = StandardTestDispatcher(testScheduler)

    override fun postProcessTestInstance(testInstance: Any?, context: ExtensionContext?) {

        (testInstance as? CoroutineTest)?.let { coroutineTest ->

            coroutineTest.testScheduler = testScheduler
        }
    }

    override fun beforeAll(context: ExtensionContext?) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun afterAll(context: ExtensionContext?) {
        Dispatchers.resetMain()
    }

}