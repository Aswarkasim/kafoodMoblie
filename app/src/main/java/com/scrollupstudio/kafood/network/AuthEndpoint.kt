package com.scrollupstudio.kafood.network

import com.scrollupstudio.kafood.data.model.login.LoginResponse
import com.scrollupstudio.kafood.data.model.register.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthEndpoint {

    @FormUrlEncoded
    @POST("auth")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("auth/register")
    fun register(
        @Field("id_user") id_user: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<RegisterResponse>
    
}