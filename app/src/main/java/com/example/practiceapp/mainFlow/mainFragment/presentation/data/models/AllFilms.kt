package com.example.practiceapp.mainFlow.mainFragment.presentation.data.models


import com.google.gson.annotations.SerializedName

data class AllFilms(
    @SerializedName("data")
    val allFilmsData: AllFilmsData? = AllFilmsData()
)