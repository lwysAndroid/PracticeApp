package com.example.practiceapp.mainFlow.mainFragment.presentation.data.models


import com.google.gson.annotations.SerializedName

data class AllFilmsData(
    @SerializedName("allFilms")
    val allFilms: AllFilmsX? = AllFilmsX()
)