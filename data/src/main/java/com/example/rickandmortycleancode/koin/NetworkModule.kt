package com.example.rickandmortycleancode.koin

import com.example.rickandmortycleancode.retrofit.RickAndMortyApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://rickandmortyapi.com/api/"

internal val networkModule = module {

    single {
        OkHttpClient.Builder().build()
    }

    single<RickAndMortyApi> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create(RickAndMortyApi::class.java)
    }
}