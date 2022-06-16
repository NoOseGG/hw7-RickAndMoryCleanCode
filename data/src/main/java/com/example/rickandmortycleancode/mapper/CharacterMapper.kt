package com.example.rickandmortycleancode.mapper

import com.example.rickandmortycleancode.model.Character
import com.example.rickandmortycleancode.model.CharacterDTO
import com.example.rickandmortycleancode.model.CharacterDetails
import com.example.rickandmortycleancode.model.CharacterDetailsDTO

fun CharacterDTO.toDomainModel(): Character {
    return Character(
        id = id,
        name = name,
        image = image,
    )
}

fun CharacterDetailsDTO.toDomainModel(): CharacterDetails {
    return CharacterDetails(
        id = id,
        name = name,
        image = image,
        status = status,
        species = species,
        type = type,
        gender = gender,
        episode = episode
    )
}