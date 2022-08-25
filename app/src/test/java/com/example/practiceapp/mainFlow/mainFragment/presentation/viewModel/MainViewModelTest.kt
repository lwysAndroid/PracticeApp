package com.example.practiceapp.mainFlow.mainFragment.presentation.viewModel

import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

class MainViewModelTest {
    private val mainViewModel = MainViewModel()

    @Test
    fun dataShouldBeHelloWorld() = runTest {
        val data = mainViewModel.fetchData()
        assertEquals("Hello world", data)
    }

}