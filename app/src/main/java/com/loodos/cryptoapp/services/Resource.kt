package com.newgamesoftware.moviesdemo_android_mvvm.service



sealed class Resource<out T> {

    data class Success<out T>(val value: T) : Resource<T>()

    data class Failure(val exception: Exception) : Resource<Nothing>()
}

