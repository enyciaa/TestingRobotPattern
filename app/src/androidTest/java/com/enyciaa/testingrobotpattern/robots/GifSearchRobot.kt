package com.enyciaa.testingrobotpattern.robots

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.enyciaa.testingrobotpattern.R
import com.enyciaa.testingrobotpattern.helpers.getString

fun search(func: GifSearchRobot.() -> Unit) = GifSearchRobot().apply { func() }

class GifSearchRobot {

    fun phrase(phrase: String) {
        onView(withText(getString(R.string.search_gif_hint))).perform(clearText(), typeText(phrase))
    }

    infix fun gifsDisplayed(func: GifSearchResultRobot.() -> Unit): GifSearchResultRobot {
        onView(withText(getString(R.string.search))).perform(click())
        return GifSearchResultRobot().apply { func() }
    }
}