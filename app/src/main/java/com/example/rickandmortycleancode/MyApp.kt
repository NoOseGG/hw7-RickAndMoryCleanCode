package com.example.rickandmortycleancode

import android.app.Application
import com.example.rickandmortycleancode.koin.dataModule
import com.example.rickandmortycleancode.koin.sharedPrefsModule
import com.example.rickandmortycleancode.koin.useCaseModule
import com.example.rickandmortycleancode.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                sharedPrefsModule,
                useCaseModule,
                viewModelModule,
                dataModule
            )
        }

    }
}