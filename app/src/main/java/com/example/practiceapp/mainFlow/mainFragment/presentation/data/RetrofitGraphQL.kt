package com.example.practiceapp.mainFlow.mainFragment.presentation.data

import com.example.practiceapp.mainFlow.mainFragment.presentation.data.models.AllFilmsData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGraphQL {

    private var starWarsApiGraphQl: StarWarsApiGraphQl? = null


    suspend fun getInternalCarList(): Result<AllFilmsData> {
        return try {
            val requestBody = GQLPostBody(carForPaperworkQuery)
            val carsResult = getRetrofit().getAllFilmsSW(requestBody).await()
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

    private val carForPaperworkQuery: String = """
          query Query {
            allFilms {
                films {
                    title
                    director
                    releaseDate
                    speciesConnection {
                      species {
                        name
                        classification
                        homeworld {
                          name
                        }
                      }
                    }
                }
           }
          }
          """.trimMargin()

}