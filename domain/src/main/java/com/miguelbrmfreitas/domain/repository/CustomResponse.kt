package com.miguelbrmfreitas.domain.repository

import java.lang.Exception

sealed class CustomResponse<out R>
{
    data class Success<out T>(val data: T) : CustomResponse<T>()
    data class Failure(val exception: Exception): CustomResponse<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success data: $data]"
            is Failure -> "Error exception: ${exception.message}]"
        }
    }
}