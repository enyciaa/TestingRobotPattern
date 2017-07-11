package com.enyciaa.testingrobotpattern

import org.junit.Test

/**
 * As a user
 * I want to get a list of gifs based on the phrase I enter
 * So I can cry with laughter
 */
class SearchGifsFeature {

    @Test
    fun givenPhraseEntered_whenSearchClicked_thenDisplayGifs() {
        search {
            phrase("Fainting Goats")
        } display {
            isSuccess()
        }
    }

}
