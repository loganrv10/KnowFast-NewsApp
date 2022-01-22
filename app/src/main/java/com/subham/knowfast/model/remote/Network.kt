package com.subham.knowfast.model.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {

    companion object{
        fun getRetrofit():Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .build()
        }

        val apiService : ApiService = getRetrofit().create(ApiService::class.java)
    }
}

/*
https://newsapi.org/v2/top-headlines?country=in&apiKey=106631ece5a74bf88ff7ca39ca05ac47
 */