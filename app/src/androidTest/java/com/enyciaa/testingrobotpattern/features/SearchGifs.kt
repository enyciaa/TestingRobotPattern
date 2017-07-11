package com.enyciaa.testingrobotpattern.features

import com.enyciaa.testingrobotpattern.robots.search
import org.junit.Test

/**
 * As a user
 * I want to get a list of gifs based on the phrase I enter
 * So I can cry with laughter
 */
class SearchGifs {

    @Test
    fun whenPhraseSearched_thenDisplayGifs() {
        search {
            phrase("Fainting Goats")
            gifsDisplayed()
        }
    }

}
