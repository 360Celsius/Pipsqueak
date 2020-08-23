package com.pipsqueak.fragments

import androidx.lifecycle.ViewModel
import com.pipsqueak.data.repositories.LocationDataByIPRepository
import com.pipsqueak.utils.Coroutines
import retrofit2.Response

class MainFragmentViewModel(

    private val locationDataByIPRepository: LocationDataByIPRepository

): ViewModel() {

    fun getLocationByIPFromAPIandSaveToDB(){
        Coroutines.backGround{

            val externalIp : Response<ExternaiIPresponce> = locationDataByIPRepository.getExternalIP()
            
            val locationDataByIPResponce : Response<LocationDataByIPresponce> = locationDataByIPRepository.getLocationDataByIP(externalIp.body()?.ip.toString())

        }
    }
}