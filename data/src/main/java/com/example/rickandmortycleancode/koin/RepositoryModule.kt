package com.example.rickandmortycleancode.koin

import com.example.rickandmortycleancode.repository.CharacterRemoteRepository
import com.example.rickandmortycleancode.repository.CharacterRemoteRepositoryImpl
import org.koin.dsl.module

internal val repositoryModule = module {

    single<CharacterRemoteRepository> {
        CharacterRemoteRepositoryImpl(
            api = get()
        )
    }
}