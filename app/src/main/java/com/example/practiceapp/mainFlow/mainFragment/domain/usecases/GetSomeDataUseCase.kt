package com.example.practiceapp.mainFlow.mainFragment.domain.usecases

import com.example.practiceapp.mainFlow.mainFragment.data.datasources.remote.apiServices.StarWarsApi
import com.example.practiceapp.mainFlow.mainFragment.domain.models.SomeData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class GetSomeDataUseCase @Inject constructor(){
    var sarWarsApi:StarWarsApi?=null

    suspend operator fun invoke(): List<SomeData> {
        val response = getRetrofit().getPeopleListSw()
        var ress: List<SomeData>? = null
        if (response.isSuccessful) {
            val body = response.body()
            ress = body?.peopleData?.map { data ->
                SomeData().apply {
                    randomData = "name: ${data.name}"
                }
            }
        }

        return ress ?: (1..20).map { SomeData().apply { randomData = "$randomData $it" } }


    }

    private fun getRetrofit(): StarWarsApi {
        if (sarWarsApi == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
//            .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            sarWarsApi = retrofit.create(StarWarsApi::class.java)
        }

        return sarWarsApi!!
    }

}