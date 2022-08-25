package com.example.practiceapp.mainFlow.mainFragment.presentation.viewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestResult
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private val mainViewModel = MainViewModel()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun dataShouldBeHelloWorld() = runTest {
        val data = mainViewModel.fetchData()
        assertEquals("Hello world", data)
    }
    @Test
    fun testFoo(): TestResult {
        // initialize some test state
        return runTest {
            // code under test
        }
    }

}