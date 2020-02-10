package com.codingtive.academycodelab.ui.pages.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.codingtive.academycodelab.R
import com.codingtive.academycodelab.core.utils.DummyData
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyCourse = DummyData.generateDummyCourses()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadCourses() {
        onView(withId(R.id.rv_academy)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourse.size))
    }

    @Test
    fun loadDetailCourse() {
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        onView(withId((R.id.tv_title))).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyCourse[1].title)))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText("Deadline ${dummyCourse[1].deadline}")))
    }

    @Test
    fun loadModules() {
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_start)).perform(click())
        onView(withId(R.id.rv_module)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailModule() {
        onView(withId(R.id.rv_academy)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_start)).perform(click())
        onView(withId(R.id.rv_module)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        onView(withId(R.id.web_view)).check(matches(isDisplayed()))
    }

    @Test
    fun loadBookmarks() {
        onView(withText("BOOKMARK")).perform(click())
        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmark)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyCourse.size))
    }
}
