package com.example.listfilm.models
data class Film (
    val title: String,
    val type: String, // "Movie" atau "Series"
    val genre: String,
    val releaseYear: Int,
    val rating: Double,
    val synopsis: String
)