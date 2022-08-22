package com.example.practiceapp.mainFlow.mainFragment.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.practiceapp.R
import com.example.practiceapp.mainFlow.mainFragment.viewModel.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        view?.findViewById<Button>(R.id.goToServiceFragment).apply {
            this?.setOnClickListener { goToServiceFragment() }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }


    private fun goToServiceFragment(){
        view?.let { Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_serviceFragment) }
//        findNavController(this).navigate(R.id.action_mainFragment_to_serviceFragment)
    }

}