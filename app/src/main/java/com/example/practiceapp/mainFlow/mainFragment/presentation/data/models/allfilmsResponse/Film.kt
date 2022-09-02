package com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.allfilmsResponse


import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("director")
    val director: String? = null,
    @SerializedName("releaseDate")
    val releaseDate: String? = null,
    @SerializedName("speciesConnection")
    val speciesConnection: SpeciesConnection? = null,
    @SerializedName("id")
    val id: String? = null
)