package com.example.rickandmortycleancode.model

import java.io.Serializable

data class Character(
    val id: Int,
    val name: String,
    val image: String,
) : Serializable