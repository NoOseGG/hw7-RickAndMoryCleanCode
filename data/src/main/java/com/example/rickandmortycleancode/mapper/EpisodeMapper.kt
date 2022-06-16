package com.example.rickandmortycleancode.mapper

import com.example.rickandmortycleancode.model.Episode
import com.example.rickandmortycleancode.model.EpisodeDTO

fun EpisodeDTO.toDomainModel(): Episode {
    return Episode(
        id = id,
        airDate = airDate,
        episode = episode,
        created = created
    )
}