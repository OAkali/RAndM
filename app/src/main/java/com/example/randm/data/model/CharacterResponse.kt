package com.example.randm.data.model

import java.io.Serializable

data class CharacterResponse(
    var result:List<Character>
): Serializable
data class Character(
    var id :Int,
    var name :String,
    var status :String,
    var imege :String,
    var species :String,
    var origin:Origin,
    var location: Location

): Serializable
data class Origin(
    var name :String
): Serializable
data class Location(
    var name :String
): Serializable

