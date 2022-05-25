package com.example.rickandmortycleancode.mapper

import com.example.rickandmortycleancode.model.Character
import com.example.rickandmortycleancode.model.CharacterDTO

fun CharacterDTO.toDomainModel(): Character {
    return Character(
        id = id,
        name = name,
        image = image,
    )
}