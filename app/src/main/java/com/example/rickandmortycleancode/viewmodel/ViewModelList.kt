package com.example.rickandmortycleancode.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmortycleancode.paging.CharacterDataSource
import com.example.rickandmortycleancode.usecase.GetRemoteCharactersUseCase
import com.example.rickandmortycleancode.usecase.GetRemotePagesCountUseCase

class ViewModelList(
    private val getRemoteCharactersUseCase: GetRemoteCharactersUseCase,
    private val getRemotePagesCountUseCase: GetRemotePagesCountUseCase
) : ViewModel(){

    val characters = Pager(PagingConfig(PAGE_SIZE)) {
        CharacterDataSource(
            getRemoteCharactersUseCase,
            getRemotePagesCountUseCase
        )
    }.flow.cachedIn(viewModelScope)

    companion object {
        private const val PAGE_SIZE = 15
    }
}