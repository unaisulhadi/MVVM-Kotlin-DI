package com.hadi.mvvmplayground.data.remote

import com.hadi.mvvmplayground.data.model.PicsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("v2/list")
    suspend fun getPictures(): Response<PicsResponse>

}