package com.example.practiceapp.mainFlow.mainFragment.presentation.data.models


import com.google.gson.annotations.SerializedName

data class Specy(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("classification")
    val classification: String? = null,
    @SerializedName("homeworld")
    val homeworld: Homeworld? = null
)