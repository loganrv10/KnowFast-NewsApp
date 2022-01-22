package com.subham.knowfast.model.remote

import com.subham.knowfast.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
   suspend fun getData(
        @Query("country")country: String,
        @Query("apikey")key:String
    ): ResponseModel
}


/*
https://newsapi.org/v2/top-headlines?country=in&apiKey=106631ece5a74bf88ff7ca39ca05ac47
 */