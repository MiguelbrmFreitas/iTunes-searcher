package com.miguelbrmfreitas.itunes_searcher

import com.miguelbrmfreitas.domain.util.extensions.toPrice
import org.junit.Assert
import org.junit.Test

class DoubleExtensionsTest
{
    companion object {
        const val FAKE_DOUBLE_1 = 2.19
        const val FAKE_DOUBLE_2 = 0.99
    }

    @Test
    fun givenDouble_toPrice_conversionIsCorrect() {
        Assert.assertEquals("$2.19", FAKE_DOUBLE_1.toPrice())
        Assert.assertEquals("$0.99", FAKE_DOUBLE_2.toPrice())
    }
}