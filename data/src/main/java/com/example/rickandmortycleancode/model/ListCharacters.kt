package com.example.rickandmortycleancode.model

data class ListCharacters(
    val info: Info,
    val results: List<Character>,
)

data class Info(
    val pages: Int,
)