package com.example.practiceapp.mainFlow.mainFragment.presentation.data

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class GQLPostBody(
    @SerializedName("query") val query: String
) {
    @SerializedName("variables")
    private var variables: String? = null

    fun <T> addVariables(variablesRequest: T): GQLPostBody {
        variables = Gson().toJson(variablesRequest).toString()
        return this
    }
}