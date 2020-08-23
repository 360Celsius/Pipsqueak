package com.pipsqueak.data.repositories

import android.util.Log
import retrofit2.Response

class LocationDataByIPRepository (
    private var apiLocationIP: LocationDataByIPapi,
    private var apiExternaliP: Externalapi

) {

    suspend fun getLocationDataByIP(ip: String): Response<LocationDataByIPresponce> {

        val locationDataByIPresponce: Response<LocationDataByIPresponce> = apiLocationIP.getLocationByIP(ip)


        Log.e("list_responce","symbol " + (locationDataByIPresponce.body()?.toString() ?: "N/A"))


        return locationDataByIPresponce
    }


    suspend fun getExternalIP(): Response<ExternaiIPresponce> {

        val externaliPPresponce: Response<ExternaiIPresponce> = apiExternaliP.getExternalIP()


        Log.e("list_responce","symbol " + (externaliPPresponce.body()?.toString() ?: "N/A"))


        return externaliPPresponce
    }
}