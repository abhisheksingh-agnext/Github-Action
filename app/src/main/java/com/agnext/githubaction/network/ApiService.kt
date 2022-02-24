package com.agnext.univerialapp.network

import com.agnext.univerialapp.network.Response.LoginResponse
import com.agnext.univerialapp.network.Response.ResUser
import com.agnext.univerialapp.network.Response.SampleRes
import retrofit2.Call
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    //Login screen
    //Oauth api
    @GET("/oauth/authorize?response_type=code&client_id=client-mobile")
    fun oauth(): Call<ResponseBody>

    //Login api
    @POST("/login?bearer=mobile")
    fun login(@Header("Cookie") sessionIdAndToken: String?, @Body request: RequestBody): Call<LoginResponse>

    //Home screen
    //Generate sample id api
    @GET("/portal/api/scan/sample-id-generation")
    fun getSampleId(@Header("authorization") authorization: String): Call<SampleRes>

    @GET("/users")
    suspend fun getUsers(): List<ResUser>

    @GET("/employees")
    suspend  fun getEmployees(): Employee

}