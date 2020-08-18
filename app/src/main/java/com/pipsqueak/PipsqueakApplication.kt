package com.pipsqueak

import android.app.Application
import com.pipsqueak.data.network.Externalapi
import com.pipsqueak.data.network.LocationDataByIPapi
import com.pipsqueak.data.repositories.LocationDataByIPRepository
import com.pipsqueak.fragments.MainFragmentViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class PipsqueakApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidCoreModule(this@PipsqueakApplication))

        bind() from singleton { LocationDataByIPapi() }
        bind() from singleton { Externalapi() }
        //bind() from singleton { DataBase(instance()) }
        bind() from singleton { LocationDataByIPRepository(instance(),instance()) }
        bind() from provider { MainFragmentViewModelFactory(instance()) }

    }

}