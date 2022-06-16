package com.example.rickandmortycleancode.koin

import androidx.room.Room
import com.example.rickandmortycleancode.room.AppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

internal val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDataBase::class.java,
            "rickandmorty.db"
        )
            .build()
    }

    single {
        get<AppDataBase>().characterDao()
    }

}