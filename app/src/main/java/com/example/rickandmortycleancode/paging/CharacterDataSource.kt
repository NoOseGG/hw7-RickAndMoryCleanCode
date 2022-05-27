package com.example.rickandmortycleancode.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortycleancode.usecase.GetRemoteCharactersUseCase
import com.example.rickandmortycleancode.usecase.GetRemotePagesCountUseCase
import com.example.rickandmortycleancode.model.Character
import java.lang.Exception

class CharacterDataSource(
    private val getRemoteCharactersUseCase: GetRemoteCharactersUseCase,
    private val getRemotePagesCountUseCase: GetRemotePagesCountUseCase
) : PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val nextPageNumber = params.key ?: 1
            val listCharacter = getRemoteCharactersUseCase.invoke(nextPageNumber)
            val pageCount = getRemotePagesCountUseCase.invoke()
            LoadResult.Page(
                data = listCharacter,
                prevKey = if (nextPageNumber > 0) nextPageNumber - 1 else null,
                nextKey = if (nextPageNumber < pageCount) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}