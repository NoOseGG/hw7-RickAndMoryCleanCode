package com.example.rickandmortycleancode.usecase

import com.example.rickandmortycleancode.model.CharacterDetails
import com.example.rickandmortycleancode.repository.CharacterRemoteRepository

class GetRemoteCharacterUseCase(
    private val characterRemoteRepository: CharacterRemoteRepository
) {

    suspend operator fun invoke(id: Int): CharacterDetails {
        return characterRemoteRepository.getCharacter(id)
    }
}