package com.example.capitnrot


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun should_hide_widgets_on_start() {

        assertVisible(R.id.capitalizeLabel)
        assertVisible(R.id.editableText)

        assertInvisible(R.id.buttonNext)
        assertInvisible(R.id.angleLabel)
        assertInvisible(R.id.angleBar)
        assertInvisible(R.id.angleValue)
    }

    @Test
    fun should_show_widgets_on_capital() {

        val editText = onView(withId(R.id.editableText))
        editText.perform(typeText("Hello"))

        assertVisible(R.id.buttonNext)
        assertVisible(R.id.angleLabel)
        assertVisible(R.id.angleBar)
        assertVisible(R.id.angleValue)
    }

    @Test
    fun should_hide_widgets_on_lower() {

        val editText = onView(withId(R.id.editableText))
        editText.perform(typeText("Hello"))
        assertVisible(R.id.buttonNext)

        editText.perform(replaceText("world"))

        assertInvisible(R.id.buttonNext)
        assertInvisible(R.id.angleLabel)
        assertInvisible(R.id.angleBar)
        assertInvisible(R.id.angleValue)
    }

    private fun assertInvisible(resId: Int) {
        onView(withId(resId)).check(matches(not(isDisplayed())))
    }

    private fun assertVisible(resId: Int) {
        onView(withId(resId)).check(matches(isDisplayed()))
    }
}
