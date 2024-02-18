package com.example.randm.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.randm.data.model.CharacterResponse
import  com.example.randm.data.model.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RMRepository @Inject constructor(private val api: CartoonApiService) {
    fun fetchCharacters(): LiveData<List<Character>> {
        val character = MutableLiveData<List<Character>>()
        api.getCharacters().enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful && response.body() != null && response.code() in 200..300) {
                    response.body()?.let {
                        character.postValue(
                            it.result
                        )
                    }
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("ololo", t.message.toString())
            }

        })
        return character
    }

    fun getCharacter(id: Int): LiveData<Character> {
        val characterLv = MutableLiveData<Character>()
        api.getCharacter(id).enqueue(object : Callback<Character> {
            override fun onResponse(
                call: Call<Character>,
                response: Response<Character>
            ) {
                if (response.isSuccessful && response.body() != null && response.code() in 200..300) {
                    response.body()?.let {
                        characterLv.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Log.e("ololo", t.message.toString())
            }
        })
        return characterLv
    }
}