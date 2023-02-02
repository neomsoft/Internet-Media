package io.neomsoft.internetmedia.data.entities

sealed class Response<out T> {

    data class Success<T>(val data: T): Response<T>()
    data class Error<T>(val exception: Throwable): Response<T>()
    class Progress<T>: Response<T>()
    class None<T>: Response<T>()
}