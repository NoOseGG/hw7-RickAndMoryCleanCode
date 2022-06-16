package com.example.rickandmortycleancode.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycleancode.model.Episode
import com.example.rickandmortycleancode.usecase.GetRemoteEpisodeUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

class ViewModelEpisodeDetails(
    private val getRemoteEpisodeUseCase: GetRemoteEpisodeUseCase,
    private val number: Int
) : ViewModel() {

     val episodeFlow = flow {
        val episode = getEpisode(number)
        emit(episode)
    }.shareIn(
        viewModelScope,
        SharingStarted.Eagerly
    )

    private suspend fun getEpisode(number: Int): Episode {
        return getRemoteEpisodeUseCase.invoke(number)
    }


}
