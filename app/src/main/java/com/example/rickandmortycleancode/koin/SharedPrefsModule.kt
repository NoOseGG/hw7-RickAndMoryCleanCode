package com.example.rickandmortycleancode.koin

import com.example.rickandmortycleancode.manager.SharedPrefsManager
import org.koin.dsl.module

val sharedPrefsModule = module {
    single {
        SharedPrefsManager(
            context = get()
        )
    }
}