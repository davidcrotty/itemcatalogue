package net.davidcrotty.itemcatalogue

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    var rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_when_navigating_invalid_path() {
        rule.scenario
        // arrange:
        // main activity
        // sprout class nav impl

        // act:
        // invoke the nav

        // assert:
        // error page is displayed
    }

}