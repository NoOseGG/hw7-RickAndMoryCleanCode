package com.example.rickandmortycleancode.repository

import com.example.rickandmortycleancode.model.Episode
import com.example.rickandmortycleancode.model.Character
import com.example.rickandmortycleancode.model.CharacterDetails

interface CharacterRemoteRepository {

    suspend fun getCharacters(page: Int): List<Character>

    suspend fun getCharacter(id: Int): CharacterDetails

    suspend fun getEpisode(number: Int): Episode

    suspend fun getPageCount(): Int
}