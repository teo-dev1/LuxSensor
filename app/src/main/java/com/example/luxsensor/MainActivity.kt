package com.example.luxsensor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.luxsensor.di.SensorApp
import com.example.luxsensor.di.SensorApp.Companion.appDependencyContainer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelCreation()
    }


    fun viewModelCreation(){
        val viewModel= ViewModelProvider(this,appDependencyContainer.mainViewModelFactory)
    }


}