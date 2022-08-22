package com.example.practiceapp.mainFlow.mainFragment.domain.usecases

import com.example.practiceapp.mainFlow.mainFragment.domain.models.SomeData
import javax.inject.Inject

class GetSomeDataUseCase @Inject constructor(){


    suspend operator fun invoke():List<SomeData> {
        return (1..20).map { SomeData().apply { randomData= "$randomData $it" } }
    }

}