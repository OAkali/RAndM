package com.example.randm.data

import com.example.randm.data.model.CharacterResponse
import  com.example.randm.data.model.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CartoonApiService {
    @GET("character/")
    fun getCharacters(): Call<CharacterResponse>
    @GET("character/{id}")
    fun getCharacter(@Path("id") id:Int): Call<Character>
}