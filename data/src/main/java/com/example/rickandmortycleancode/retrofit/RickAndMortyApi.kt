package com.example.rickandmortycleancode.retrofit

import com.example.rickandmortycleancode.model.CharacterDetailsDTO
import com.example.rickandmortycleancode.model.EpisodeDTO
import com.example.rickandmortycleancode.model.ListCharacters
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character/?")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): ListCharacters

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ): CharacterDetailsDTO

    @GET("episode/{number}")
    suspend fun getEpisode(
        @Path("number") number: Int
    ): EpisodeDTO

    @GET("character")
    suspend fun getAllCharacters(): ListCharacters
}