package com.example.practiceapp.mainFlow.servicePractice.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practiceapp.mainFlow.mainFragment.domain.models.SomeData
import com.example.practiceapp.mainFlow.mainFragment.domain.usecases.GetSomeDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServiceViewModel @Inject constructor(
    private val getSomeDataUseCase: GetSomeDataUseCase
) : ViewModel() {

    private val _showSomeData: MutableLiveData<List<SomeData>> = MutableLiveData()
    val showSomeData: LiveData<List<SomeData>> = _showSomeData


    fun callService() {
        viewModelScope.launch {
            val response = getSomeDataUseCase()
            _showSomeData.value = response
        }
    }


}