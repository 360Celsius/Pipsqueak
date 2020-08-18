package com.pipsqueak.data.repositories

import android.util.Log
import com.pipsqueak.data.network.Externalapi
import com.pipsqueak.data.network.LocationDataByIPapi
import com.pipsqueak.data.network.responce.ExternaiIPresponce
import com.pipsqueak.data.network.responce.LocationDataByIPresponce
import retrofit2.Response

class LocationDataByIPRepository (
    private var apiLocationIP: LocationDataByIPapi,
    private var apiExternaliP: Externalapi

) {

    suspend fun getLocationDataByIP(): Response<LocationDataByIPresponce> {

        val locationDataByIPresponce: Response<LocationDataByIPresponce> = apiLocationIP.getLocationByIP()


        Log.e("list_responce","symbol " + (locationDataByIPresponce.body()?.toString() ?: "N/A"))


        return locationDataByIPresponce
    }


    suspend fun getExternalIP(): Response<ExternaiIPresponce> {

        val externaliPPresponce: Response<ExternaiIPresponce> = apiExternaliP.getExternalIP()


        Log.e("list_responce","symbol " + (externaliPPresponce.body()?.toString() ?: "N/A"))


        return externaliPPresponce
    }
}