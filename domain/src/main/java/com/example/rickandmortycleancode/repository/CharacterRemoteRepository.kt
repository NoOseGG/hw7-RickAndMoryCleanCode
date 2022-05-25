package com.example.rickandmortycleancode.repository

import com.example.rickandmortycleancode.model.Character
import com.example.rickandmortycleancode.model.CharacterDetails
import com.example.rickandmortycleancode.model.Episode

interface CharacterRemoteRepository {

    suspend fun getCharacters(page: Int): Result<List<Character>>

    suspend fun getCharacter(id: Int): Result<CharacterDetails>

    suspend fun getEpisode(number: Int): Result<Episode>
}