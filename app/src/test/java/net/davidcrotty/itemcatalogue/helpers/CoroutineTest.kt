package net.davidcrotty.itemcatalogue.helpers

import kotlinx.coroutines.test.TestCoroutineScheduler
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestCoroutineExtension::class)
interface CoroutineTest {
    var testScheduler: TestCoroutineScheduler
}