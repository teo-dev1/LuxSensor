package com.example.luxsensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.luxsensor.di.SensorApp
import com.example.luxsensor.di.SensorApp.Companion.appDependencyContainer
import com.example.luxsensor.factory.MainViewModelFactory
import com.example.luxsensor.utils.MeasurableSensor
import com.example.luxsensor.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val viewModel= ViewModelProvider(this,appDependencyContainer.mainViewModelFactory).get(MainViewModel::class.java)
    }
}