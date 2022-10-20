package com.miguelbrmfreitas.data

import com.miguelbrmfreitas.data.remote.mappers.toDomainEntity
import com.miguelbrmfreitas.data.remote.response.SearchResultResponse
import com.miguelbrmfreitas.domain.entities.SearchResult
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MapperTest {

    companion object {
        // Values for mock SearchResultResponse object
        const val ARTIST_NAME = "Shakira"
        const val IMAGE_COVER_URL = "https://test"
        const val PREVIEW_URL = "https://test"
        const val TRACK_NAME = "She Wolf"
        const val TRACK_ID = 1
        const val ALBUM_NAME = "She Wolf (Deluxe Edition)"
        const val RELEASE_DATE = "2009-07-10T07:00:00Z"
        const val PRIMARY_GENRE_NAME = "Pop Latino"
        const val TRACK_PRICE = 1.29

        // How the RELEASE_DATE above should be formatted
        const val VALID_FORMATTED_DATE = "Jul 10, 2009"

        // How the created LocalDateTime object should store values converted from RELEASE_DATE
        const val VALID_YEAR = 2009
        const val VALID_MONTH = 7
        const val VALID_DAY_OF_MONTH = 10
    }

    // Domain entity
    lateinit var searchResult: SearchResult

    // Network entity that has method to covert to domain entity
    lateinit var searchResultResponse: SearchResultResponse

    @Before
    fun initializeTests() {
        searchResultResponse = SearchResultResponse(
            artistName = ARTIST_NAME,
            imageCoverUrl = IMAGE_COVER_URL,
            previewUrl = PREVIEW_URL,
            trackName = TRACK_NAME,
            trackId = TRACK_ID,
            albumName = ALBUM_NAME,
            releaseDate = RELEASE_DATE,
            primaryGenreName = PRIMARY_GENRE_NAME,
            trackPrice = TRACK_PRICE
        )

        // should map network entity to domain entity correctly
        searchResult = searchResultResponse.toDomainEntity()
    }

    // Check the properties that don't need additional formatting/transformation
    @Test
    fun givenSearchResult_checkIfNotFormattedProperties_areValid() {
        assertEquals(ARTIST_NAME, searchResult.artistName)
        assertEquals(IMAGE_COVER_URL, searchResult.imageCoverUrl)
        assertEquals(PREVIEW_URL, searchResult.previewUrl)
        assertEquals(TRACK_NAME, searchResult.trackName)
        assertEquals(TRACK_ID, searchResult.trackId)
        assertEquals(ALBUM_NAME, searchResult.albumName)
        assertEquals(PRIMARY_GENRE_NAME, searchResult.primaryGenreName)
    }

    // Check if formattedDate was converted from releaseDate correctly
    @Test
    fun givenSearchResult_checkIfFormattedDate_isValid() {
        assertEquals(searchResult.formattedDate, VALID_FORMATTED_DATE)
    }

    // Check if Date object created is correct
    @Test
    fun givenSearchResult_checkIfReleaseDate_isValid() {
        assertEquals(VALID_YEAR, searchResult.releaseDate.year)
        assertEquals(VALID_MONTH, searchResult.releaseDate.month.value)
        assertEquals(VALID_DAY_OF_MONTH, searchResult.releaseDate.dayOfMonth)
    }

}