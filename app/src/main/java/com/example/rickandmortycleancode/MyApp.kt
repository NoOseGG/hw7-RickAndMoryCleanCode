package com.example.rickandmortycleancode

import android.app.Application
import com.example.rickandmortycleancode.koin.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                dataModule,
            )
        }

    }
}