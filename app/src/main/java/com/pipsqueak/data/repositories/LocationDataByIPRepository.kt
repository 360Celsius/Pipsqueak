package com.pipsqueak.data.repositories

import android.util.Log
import com.pipsqueak.data.network.LocationDataByIPapi
import com.pipsqueak.data.network.responce.LocationDataByIPresponce
import retrofit2.Response

class LocationDataByIPRepository (
    private var api: LocationDataByIPapi
) {

    suspend fun getLocationDataByIP(): Response<LocationDataByIPresponce> {

        val locationDataByIPresponce: Response<LocationDataByIPresponce> = api.getLocationByIP()


        Log.e("list_responce","symbol " + (locationDataByIPresponce.body()?.toString() ?: "N/A"))


        return locationDataByIPresponce
    }
}