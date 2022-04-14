package net.davidcrotty.itemcatalogue.helpers

import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestCoroutineExtension::class)
interface CoroutineTest {
    var testScope: TestCoroutineScope
    var dispatcher: TestCoroutineDispatcher
}