package com.example.practiceapp.mainFlow.mainFragment.data.datasources.remote.models

import com.google.gson.annotations.SerializedName

data class PeopleListSwResponse(
    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("next")
    var next: String? = null,
    @SerializedName("previous")
    var previous: Any? = null,
    @SerializedName("results")
    var peopleData: List<PeopleDataResponse>? = null
)
