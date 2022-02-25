package com.agnext.githubaction.network.response

import com.agnext.githubaction.AppStates.USER_ERROR
import com.agnext.githubaction.AppStates.USER_LOADING
import com.agnext.githubaction.AppStates.USER_SUCCESS


data class Resource<out T>(val status: String, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): Resource<T> = Resource(status = USER_SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): Resource<T> =
            Resource(status = USER_ERROR, data = data, message = message)

        fun <T> loading(data: T?): Resource<T> = Resource(status =USER_LOADING , data = data, message = null)
    }
}