package com.pipsqueak.data.network

import com.pipsqueak.data.network.responce.LocationDataByIPresponce
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface LocationDataByIPapi {

    @GET("json/45.34.147.118")
    suspend fun getLocationByIP(): Response<LocationDataByIPresponce>

    companion object{
        operator fun invoke(): LocationDataByIPapi {
            return Retrofit.Builder()
                .baseUrl("https://freegeoip.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LocationDataByIPapi::class.java)
        }
    }

}