package com.example.practiceapp.mainFlow.mainFragment.presentation.data

import com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.allfilmsResponse.AllFilmsData
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface StarWarsApiGraphQl {

//    @POST("/")
    @POST(".netlify/functions/index/")
    fun getAllFilmsSW(@Body query: GQLPostBody): Deferred<WrapperResponse<AllFilmsData>>

}