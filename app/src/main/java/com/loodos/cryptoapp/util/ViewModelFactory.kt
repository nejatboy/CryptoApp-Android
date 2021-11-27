package com.loodos.cryptoapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.loodos.cryptoapp.repository.BaseRepository



@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: BaseRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return throw IllegalArgumentException("ViewModelClass Not Fount")
        /*return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as MovieRepository) as T
            modelClass.isAssignableFrom(TopViewModel::class.java) -> TopViewModel(repository as MovieRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Fount")
        }*/
    }
}