package com.example.rickandmortycleancode.repository

import com.example.rickandmortycleancode.model.Character
import com.example.rickandmortycleancode.model.CharacterDetails
import com.example.rickandmortycleancode.model.Episode
import com.example.rickandmortycleancode.retrofit.RickAndMortyApi

class CharacterRemoteRepositoryImpl(
    private val api: RickAndMortyApi
) : CharacterRemoteRepository {
    override suspend fun getCharacters(page: Int): Result<List<Character>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacter(id: Int): Result<CharacterDetails> {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisode(number: Int): Result<Episode> {
        TODO("Not yet implemented")
    }

}