package com.example.practiceapp.mainFlow.mainFragment.presentation.data

import com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.allfilmsResponse.AllFilmsData
import com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.filmDataResponse.FilmDataResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface StarWarsApiGraphQl {

    @POST(".netlify/functions/index/")
    fun getAllFilmsSW(@Body query: GQLPostBody): Deferred<WrapperResponse<AllFilmsData>>

    @POST(".netlify/functions/index/")
    fun getAllFilmDataSW(@Body query: GQLPostBody): Deferred<WrapperResponse<FilmDataResponse>>

}