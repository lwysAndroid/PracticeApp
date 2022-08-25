package com.example.practiceapp.mainFlow.mainFragment.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {


    suspend fun fetchData(): String {
        delay(1000L)
        return "Hello world"
    }

}