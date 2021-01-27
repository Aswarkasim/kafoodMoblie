package com.scrollupstudio.kafood.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiService {

    val BASE_URL: String = "http://gcs.scrollupstudio.com/api/"

    val auth: AuthEndpoint
    get() {
        return retrofit.create(AuthEndpoint::class.java)
    }

    val warung: WarungEndpoint
    get() {
        return retrofit.create(WarungEndpoint::class.java)
    }

    val user: UserEndpoint
    get() {
        return retrofit.create(UserEndpoint::class.java)
    }

    val retrofit: Retrofit
    get() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}