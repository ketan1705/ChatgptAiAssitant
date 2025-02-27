package com.ken.chatgptaiassitant.utils

sealed class NetworkResult<out T> {
    class Success<out T>(val data: T) : NetworkResult<T>()
    class Error<out T>(val exception: Exception) : NetworkResult<T>()
    class Loading<out T> : NetworkResult<T>()
}