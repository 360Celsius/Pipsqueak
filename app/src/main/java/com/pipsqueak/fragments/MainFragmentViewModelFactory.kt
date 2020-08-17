package com.pipsqueak.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pipsqueak.data.repositories.LocationDataByIPRepository

@Suppress("UNCHECKED_CAST")
class MainFragmentViewModelFactory (

    private val repository: LocationDataByIPRepository

): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainFragmentViewModel(repository) as T
    }
}