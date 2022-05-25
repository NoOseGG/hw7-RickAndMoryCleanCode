package com.example.rickandmortycleancode.repository

import com.example.rickandmortycleancode.model.Character
import com.example.rickandmortycleancode.model.CharacterDetails
import com.example.rickandmortycleancode.model.Episode

interface UserRemoteRepository {

    suspend fun getAllCharacters(page: Int): List<Character>

    suspend fun getCharacter(id: Int): CharacterDetails

    suspend fun getEpisode(number: Int): Episode
}