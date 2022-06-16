package com.example.rickandmortycleancode.koin


import com.example.rickandmortycleancode.viewmodel.ViewModelEpisodeDetails
import com.example.rickandmortycleancode.viewmodel.ViewModelList
import com.example.rickandmortycleancode.viewmodel.ViewModelDetailsFragment
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::ViewModelList)
    viewModelOf(::ViewModelEpisodeDetails)
    viewModelOf(::ViewModelDetailsFragment)
}