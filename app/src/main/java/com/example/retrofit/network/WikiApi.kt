package com.example.retrofit.network

import com.example.retrofit.model.WikiResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WikiApi {
    @GET("w/api.php?action=query&format=json&list=search")
    suspend fun getHitsForName(@Query("srsearch") name: String): WikiResponse

    companion object {
        private const val BASE_URL = "https://en.wikipedia.org/"

        fun create(): WikiApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WikiApi::class.java)
        }
    }
}
