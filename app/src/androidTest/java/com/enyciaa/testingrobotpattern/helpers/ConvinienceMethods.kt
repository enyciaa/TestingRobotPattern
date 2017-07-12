package com.enyciaa.testingrobotpattern.helpers

import android.support.test.InstrumentationRegistry

fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
    return RecyclerViewMatcher(recyclerViewId);
}

fun getString(id: Int): String {
    val targetContext = InstrumentationRegistry.getTargetContext()
    return targetContext.resources.getString(id)
}
