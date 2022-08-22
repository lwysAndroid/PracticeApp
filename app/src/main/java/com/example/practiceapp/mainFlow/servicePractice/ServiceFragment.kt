package com.example.practiceapp.mainFlow.servicePractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.practiceapp.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ServiceFragment : Fragment() {


    private val viewModel by viewModels<ServiceViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_service, container, false)
    }

}