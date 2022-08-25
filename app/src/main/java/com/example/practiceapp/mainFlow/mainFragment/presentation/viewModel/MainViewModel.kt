package com.example.practiceapp.mainFlow.mainFragment.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {


    suspend fun fetchData(): String {
        var response = ""
        withContext(Dispatchers.IO) {
            delay(5000L)
            response = "Hello world"
        }
        return response
    }

}