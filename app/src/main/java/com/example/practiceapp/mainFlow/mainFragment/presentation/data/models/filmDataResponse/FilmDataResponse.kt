package com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.filmDataResponse


import com.google.gson.annotations.SerializedName

data class FilmDataResponse(
    @SerializedName("film")
    val film: Film? = null
)