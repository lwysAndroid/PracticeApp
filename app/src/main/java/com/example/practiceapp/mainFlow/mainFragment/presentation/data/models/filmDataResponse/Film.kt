package com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.filmDataResponse


import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("director")
    val director: String? = null,
    @SerializedName("created")
    val created: String? = null
)