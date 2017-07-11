package com.enyciaa.testingrobotpattern.robots

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import com.enyciaa.testingrobotpattern.R
import com.enyciaa.testingrobotpattern.helpers.withRecyclerView

fun search(func: GifSearchScreenRobot.() -> Unit) = GifSearchScreenRobot().apply { func() }

class GifSearchScreenRobot {

    fun phrase(phrase: String) {

    }

    fun gifsDisplayed() {
        onView(withRecyclerView(R.id.listOfGifs).atPosition(0)).check(matches(isDisplayed()))
    }
}