package com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.allfilmsResponse


import com.google.gson.annotations.SerializedName

data class SpeciesConnection(
    @SerializedName("species")
    val species: List<Specy?>? = null
)