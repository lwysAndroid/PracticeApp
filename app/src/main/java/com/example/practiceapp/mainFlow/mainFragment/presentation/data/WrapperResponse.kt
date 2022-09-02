package com.example.practiceapp.mainFlow.mainFragment.presentation.data

import com.google.gson.annotations.SerializedName

data class WrapperResponse<T> (
    @SerializedName("data")
    val data: T
)