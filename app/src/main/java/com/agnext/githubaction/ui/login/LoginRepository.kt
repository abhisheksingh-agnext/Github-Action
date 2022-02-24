package com.agnext.githubaction.ui.login

import android.content.Context
import com.agnext.univerialapp.network.Response.LoginResponse

class LoginRepository(apiClient: String, context: Context) {
    fun login(username: String, password: String, mCallback: LoginRepositoryCallback) {
//        oauthApi(username, password, mCallback)
        if (username == "User" && password == "1234") {
            mCallback.loginSuccess("Successfully login")
        } else {
            mCallback.loginFailure("Error to login")
        }
    }
    interface LoginRepositoryCallback {
        fun loginSuccess(msg: String)
        fun loginFailure(msg: String)
    }
}