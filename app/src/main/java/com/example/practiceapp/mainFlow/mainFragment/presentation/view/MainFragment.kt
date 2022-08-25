package com.example.practiceapp.mainFlow.mainFragment.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.practiceapp.R
import com.example.practiceapp.mainFlow.mainFragment.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class MainFragment : Fragment() {


    private val viewModel by viewModels<MainViewModel>()

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

        view?.findViewById<Button>(R.id.runCoroutine).apply {
            this?.setOnClickListener {
                lifecycleScope.launch(context = Dispatchers.IO,
                    start = CoroutineStart.DEFAULT,
                    block = { println("newCoroutine") }
                )
                lifecycleScope.launch {
                    /*runBlocking {
                        (0 until 15).forEach{
                            println("runBlocking $it")
                            delay(1000)
                        }
                    }*/
                    /*withContext(Dispatchers.Main){
                        (0 until 15).forEach{
                            println("Main $it")
                            delay(1000)
                        }
                    }*/
                    val job = withContext(Job()+Dispatchers.IO+CoroutineName("OwMAne")){
                        val coonT =this.coroutineContext.toString()
                        (0 until 5).forEach{
                            println("$coonT $it")
                            if(it==2){
                                coroutineContext.job.cancel()
                            }
                            delay(1000)
                        }
                    }
                    println(job.toString())
                }
            }

        }
    }

    private fun goToServiceFragment(){
        findNavController().navigate(R.id.action_mainFragment_to_serviceFragment)
    }

}