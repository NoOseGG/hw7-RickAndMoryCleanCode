package com.example.rickandmortycleancode.model

import com.google.gson.annotations.SerializedName

class EpisodeDTO(
    val id: Int,
    @SerializedName("air_date")
    val airDate: String,
    val episode: String,
    val created: String
)