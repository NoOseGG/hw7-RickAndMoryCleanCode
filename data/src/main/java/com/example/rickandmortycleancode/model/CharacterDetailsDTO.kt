package com.example.rickandmortycleancode.model

data class CharacterDetailsDTO(
    val id: Int,
    val name: String,
    val image: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val episode: List<String>,
)