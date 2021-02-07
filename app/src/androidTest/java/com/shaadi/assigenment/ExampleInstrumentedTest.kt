package com.shaadi.assigenment

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.shaadi.assigenment.testutils.DataBindingIdlingResourceRule
import com.shaadi.assigenment.ui.MatchCardListActivity
import com.shaadi.assigenment.ui.fragments.MatchCardListFragment
import com.shaadi.assigenment.util.Task
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : KoinTest{
    /* Instantiate an IntentsTestRule object. */
    @get:Rule
    var activityRule: ActivityScenarioRule<MatchCardListActivity> =
        ActivityScenarioRule(MatchCardListActivity::class.java)

    @Rule
    @JvmField
    val dataBindingIdlingResourceRule = DataBindingIdlingResourceRule(activityRule)


    fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }

    @Before
    fun registerIdlingResource() {
        activityRule.scenario.onActivity {
            it.supportFragmentManager.beginTransaction().replace(
                R.id.fragmentContainer, MatchCardListFragment.newInstance(),
                Task.ARTICLE_LIST_FRAGMENT.name
            ).commitAllowingStateLoss()
            Thread.sleep(500)
        }


    }

    @After
    fun unregisterIdlingResource() {
    }


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext: Context = getInstrumentation().targetContext
        assertEquals(
            "com.shaadi.assigenment",
            appContext.packageName
        )
    }

    @Test
    fun testRecyclerView() {
        onView(withId(R.id.rvMatchCardList)).check(matches(isDisplayed()))
    }

    @Test
    fun testRecyclerViewItem() {

        onView(withRecyclerView(R.id.rvMatchCardList).atPositionOnView(0, R.id.tvUserName)).check(
            matches(isDisplayed())
        )

        onView(withRecyclerView(R.id.rvMatchCardList).atPositionOnView(0, R.id.tvUserDetail)).check(
            matches(isDisplayed())
        )

    }



    inner class ClickOnButtonView : ViewAction {
        private var click = click()

        override fun getConstraints(): Matcher<View> {
            return click.constraints
        }

        override fun getDescription(): String {
            return " click on custom button view"
        }

        override fun perform(uiController: UiController, view: View) {

        }

    }


    fun setTextInTextView(value: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return CoreMatchers.allOf(
                    isDisplayed(), isAssignableFrom(
                    TextView::class.java)
                )
            }

            override fun perform(uiController: UiController, view: View) {
                (view as TextView).text = value
            }

            override fun getDescription(): String {
                return "replace text"
            }
        }
    }
}