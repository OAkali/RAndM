package com.example.randm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import  com.example.randm.data.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: RMRepository) : ViewModel() {
    fun getCharacters(): LiveData<List<Character>> {
        return repository.fetchCharacters()
    }

    fun getData(id: Int): LiveData<Character> {
        return repository.getCharacter(id)
    }

}