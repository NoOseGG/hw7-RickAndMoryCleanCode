package com.example.rickandmortycleancode.usecase

import com.example.rickandmortycleancode.model.Episode
import com.example.rickandmortycleancode.repository.CharacterRemoteRepository

class GetRemoteEpisodeUseCase(
    private val characterRemoteRepository: CharacterRemoteRepository
) {

    suspend operator fun invoke(number: Int): Episode {
        return characterRemoteRepository.getEpisode(number)
    }
}