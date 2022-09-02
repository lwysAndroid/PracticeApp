package com.example.practiceapp.mainFlow.mainFragment.presentation.data

import com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.GetFilmDataRequest
import com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.allfilmsResponse.AllFilmsData
import com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.filmDataResponse.FilmDataResponse
import com.example.practiceapp.mainFlow.mainFragment.presentation.data.queries.getAllFilmsQuery
import com.example.practiceapp.mainFlow.mainFragment.presentation.data.queries.getFilmDataQuery
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGraphQL {

    private var starWarsApiGraphQl: StarWarsApiGraphQl? = null


    suspend fun getAllFilms(): Result<AllFilmsData> {
        return try {
            val requestBody = GQLPostBody(getAllFilmsQuery)
            val carsResult = getRetrofit().getAllFilmsSW(requestBody).await()
            Result.Success(carsResult.data)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    suspend fun getFilmById(filmId: Int = 5): Result<FilmDataResponse> {
        return try {
            val getFilmDataRequest = GetFilmDataRequest(filmId = filmId)
            val requestBody = GQLPostBody(getFilmDataQuery).addVariables(getFilmDataRequest)
            val carsResult = getRetrofit().getAllFilmDataSW(requestBody).await()
            Result.Success(carsResult.data)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    private fun getRetrofit(): StarWarsApiGraphQl {
        if (starWarsApiGraphQl == null) {
            val retrofit =
                Retrofit.Builder()
                    .baseUrl("https://swapi-graphql.netlify.app/")
//                    .baseUrl("https://swapi-graphql.netlify.app/.netlify/functions/index/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()

            starWarsApiGraphQl = retrofit.create(StarWarsApiGraphQl::class.java)
        }

        return starWarsApiGraphQl!!
    }



}