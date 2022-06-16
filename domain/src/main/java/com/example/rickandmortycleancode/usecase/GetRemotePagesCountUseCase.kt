package com.example.rickandmortycleancode.usecase

import com.example.rickandmortycleancode.repository.CharacterRemoteRepository

class GetRemotePagesCountUseCase(
    private val characterRemoteRepository: CharacterRemoteRepository
) {

    suspend operator fun invoke(): Int {
        return characterRemoteRepository.getPageCount()
    }
}