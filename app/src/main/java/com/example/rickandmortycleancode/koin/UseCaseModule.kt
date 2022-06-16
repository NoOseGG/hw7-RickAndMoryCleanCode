package com.example.rickandmortycleancode.koin

import com.example.rickandmortycleancode.usecase.GetRemoteCharacterUseCase
import com.example.rickandmortycleancode.usecase.GetRemoteCharactersUseCase
import com.example.rickandmortycleancode.usecase.GetRemoteEpisodeUseCase
import com.example.rickandmortycleancode.usecase.GetRemotePagesCountUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { GetRemotePagesCountUseCase(get()) }
    factory { GetRemoteCharactersUseCase(get()) }
    factory { GetRemoteEpisodeUseCase(get()) }
    factory { GetRemoteCharacterUseCase(get()) }
}