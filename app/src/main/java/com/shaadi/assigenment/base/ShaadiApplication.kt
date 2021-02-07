package com.shaadi.assigenment.base


import android.app.Application
import com.shaadi.assigenment.di.appModule
import com.shaadi.assigenment.di.repoModule
import com.shaadi.assigenment.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class ShaadiApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ShaadiApplication)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}