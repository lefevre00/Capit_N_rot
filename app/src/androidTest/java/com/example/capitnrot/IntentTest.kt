package com.example.capitnrot


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class IntentTest {

    @Rule
    @JvmField
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun should_send_angle_in_intent() {

        val editText = onView(withId(R.id.editableText))
        editText.perform(typeText("Hello"), closeSoftKeyboard())


        onView(withId(R.id.buttonNext)).perform(click())

        Intents.intended(hasExtra(MainActivity.EXTRA_ANGLE, 90))

    }

}
