package com.codingtive.jetpack.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.codingtive.jetpack.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    private val dummyVolume = "24.0"
    private val dummyCircumference = "96.0"
    private val dummySurfaceArea = "52.0"

    private val dummyLength = "2"
    private val dummyWidth = "3"
    private val dummyHeight = "4"
    private val emptyInput = ""
    private val errorEmptyInput = "Field must not be empty"

    @get:Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun assertGetVolume() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_calculate_volume)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate_volume)).perform(click())

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result)).check(matches(withText(dummyVolume)))
    }

    @Test
    fun assertGetCircumference() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_calculate_circumference)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate_circumference)).perform(click())

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result)).check(matches(withText(dummyCircumference)))
    }

    @Test
    fun assertGetSurfaceArea() {
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())

        onView(withId(R.id.btn_calculate_surface_area)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_calculate_surface_area)).perform(click())

        onView(withId(R.id.tv_result)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_result)).check(matches(withText(dummySurfaceArea)))
    }

    @Test
    fun assertEmptyInput() {
        // check empty length
        onView(withId(R.id.edt_length)).perform(typeText(emptyInput), closeSoftKeyboard())
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.edt_length)).check(matches(hasErrorText(errorEmptyInput)))
        onView(withId(R.id.edt_length)).perform(typeText(dummyLength), closeSoftKeyboard())

        // check empty width
        onView(withId(R.id.edt_width)).perform(typeText(emptyInput), closeSoftKeyboard())
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.edt_width)).check(matches(hasErrorText(errorEmptyInput)))
        onView(withId(R.id.edt_width)).perform(typeText(dummyWidth), closeSoftKeyboard())

        // check empty height
        onView(withId(R.id.edt_height)).perform(typeText(emptyInput), closeSoftKeyboard())
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
        onView(withId(R.id.edt_height)).check(matches(hasErrorText(errorEmptyInput)))
        onView(withId(R.id.edt_height)).perform(typeText(dummyHeight), closeSoftKeyboard())

        onView(withId(R.id.btn_save)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_save)).perform(click())
    }
}
