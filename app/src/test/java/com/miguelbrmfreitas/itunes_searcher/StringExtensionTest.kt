package com.miguelbrmfreitas.itunes_searcher

import com.miguelbrmfreitas.domain.util.extensions.toFormattedDate
import org.junit.Test
import kotlin.test.assertEquals

class StringExtensionTest
{
    companion object {
        const val FAKE_API_DATE = "2009-07-10T07:00:00Z"
        const val VALID_FORMATTED_DATE = "Jul 10, 2009"
    }

    @Test
    fun givenApiStringDate_convertToValid_formattedDate() {
        assertEquals(VALID_FORMATTED_DATE, FAKE_API_DATE.toFormattedDate())
    }
}