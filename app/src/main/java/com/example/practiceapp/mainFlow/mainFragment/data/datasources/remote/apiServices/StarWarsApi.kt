package com.example.practiceapp.mainFlow.mainFragment.data.datasources.remote.apiServices

import com.example.practiceapp.mainFlow.mainFragment.data.datasources.remote.models.PeopleListSwResponse
import retrofit2.Response
import retrofit2.http.GET

interface StarWarsApi {

    @GET("people/")
    suspend fun getPeopleListSw(): Response<PeopleListSwResponse>

}
