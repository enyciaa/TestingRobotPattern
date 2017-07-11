package com.enyciaa.testingrobotpattern.helpers

import android.view.View

class RecyclerViewMatcher(private val recyclerViewId: Int) {

    fun atPosition(position: Int): org.hamcrest.Matcher<View> {
        return atPositionOnView(position, -1)
    }

    fun atPositionOnView(position: Int, targetViewId: Int): org.hamcrest.Matcher<View> {
        return object : org.hamcrest.TypeSafeMatcher<View>() {
            internal var resources: android.content.res.Resources? = null
            internal var childView: android.view.View? = null

            override fun describeTo(description: org.hamcrest.Description) {
                var idDescription = Integer.toString(recyclerViewId)
                if (this.resources != null) {
                    try {
                        idDescription = this.resources!!.getResourceName(recyclerViewId)
                    } catch (var4: android.content.res.Resources.NotFoundException) {
                        idDescription = String.format("%s (resource name not found)",
                                *arrayOf<Any>(Integer.valueOf(recyclerViewId)))
                    }

                }

                description.appendText("with id: " + idDescription)
            }

            override fun matchesSafely(view: android.view.View): Boolean {
                this.resources = view.getResources()

                if (childView == null) {
                    val recyclerView = view.getRootView().findViewById<android.support.v7.widget.RecyclerView>(recyclerViewId)
                    if (recyclerView != null && recyclerView!!.getId() === recyclerViewId) {
                        childView = recyclerView!!.findViewHolderForAdapterPosition(position).itemView
                    } else {
                        return false
                    }
                }

                if (targetViewId == -1) {
                    return view === childView
                } else {
                    val targetView = childView!!.findViewById<android.view.View>(targetViewId)
                    return view === targetView
                }

            }
        }
    }
}
