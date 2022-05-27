package com.example.rickandmortycleancode.repository

import com.example.rickandmortycleancode.mapper.toDomainModel
import com.example.rickandmortycleancode.model.Character
import com.example.rickandmortycleancode.model.CharacterDetails
import com.example.rickandmortycleancode.model.Episode
import com.example.rickandmortycleancode.retrofit.RickAndMortyApi

class CharacterRemoteRepositoryImpl(
    private val api: RickAndMortyApi
) : CharacterRemoteRepository {

    override suspend fun getCharacters(page: Int): List<Character> {
        val listCharacter = api.getAllCharacters(page)
        return listCharacter.results
    }

    override suspend fun getCharacter(id: Int): CharacterDetails {
        return api.getCharacter(id).toDomainModel()
    }

    override suspend fun getEpisode(number: Int): Episode {
        return api.getEpisode(number).toDomainModel()
    }

    override suspend fun getPageCount(): Int {
        return api.getAllCharacters().info.pages
    }

}