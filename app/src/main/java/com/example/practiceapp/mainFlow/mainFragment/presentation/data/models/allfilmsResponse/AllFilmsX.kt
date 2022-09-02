package com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.allfilmsResponse


import com.google.gson.annotations.SerializedName

data class AllFilmsX(
    @SerializedName("films")
    val films: List<Film?>? = null
)