package com.example.practiceapp.mainFlow.servicePractice.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.practiceapp.R
import com.example.practiceapp.mainFlow.servicePractice.presentation.viewModel.ServiceViewModel
import com.google.android.material.button.MaterialButton
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        view?.apply {
            findViewById<MaterialButton>(R.id.callServiceBtn)
                .apply { setOnClickListener { viewModel.callService() } }
        }
    }

    private fun setObservers() {
        viewModel.showSomeData.observe(viewLifecycleOwner){someDataList->
            var textToShow =""
            someDataList.forEach { textToShow += "${it.randomData},\n" }
            view?.findViewById<TextView>(R.id.responseTv)?.apply {
                text = textToShow
            }
        }
    }


}