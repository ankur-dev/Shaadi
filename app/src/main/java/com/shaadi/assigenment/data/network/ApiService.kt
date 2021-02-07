package com.shaadi.assigenment.data.network


import com.shaadi.assigenment.data.model.ShaadiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("api")
   suspend fun getShaadiItemRecords(@Query("results") itemCountPerPage:Int): Response<ShaadiResponse>

}