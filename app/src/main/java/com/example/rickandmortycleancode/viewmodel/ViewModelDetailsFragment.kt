package com.example.rickandmortycleancode.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycleancode.model.CharacterDetails
import com.example.rickandmortycleancode.usecase.GetRemoteCharacterUseCase
import kotlinx.coroutines.flow.*

class ViewModelDetailsFragment(
    private val getRemoteCharacterUseCase: GetRemoteCharacterUseCase,
    private val id: Int
) : ViewModel() {

    val characterFlow = flow {
        val character = loadCharacter(id)
        emit(character)
    }.shareIn(
        viewModelScope,
        SharingStarted.Eagerly,
        replay = 1
    )

    private suspend fun loadCharacter(id: Int): CharacterDetails {
        return getRemoteCharacterUseCase.invoke(id)
    }
}