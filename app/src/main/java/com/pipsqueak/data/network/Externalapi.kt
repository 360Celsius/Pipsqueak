package com.pipsqueak.data.network

import com.pipsqueak.data.network.responce.ExternaiIPresponce
import com.pipsqueak.data.network.responce.LocationDataByIPresponce
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Externalapi {

    @GET()
    suspend fun getExternalIP(): Response<ExternaiIPresponce>

    companion object{
        operator fun invoke(): Externalapi {
            return Retrofit.Builder()
                .baseUrl("https://api.myip.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Externalapi::class.java)
        }
    }

}