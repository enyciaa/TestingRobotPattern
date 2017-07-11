package com.enyciaa.testingrobotpattern.helpers

fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
    return RecyclerViewMatcher(recyclerViewId);
}
