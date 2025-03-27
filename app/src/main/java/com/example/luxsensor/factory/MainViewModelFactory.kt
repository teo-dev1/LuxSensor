package com.example.luxsensor.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.luxsensor.utils.LightSensor
import com.example.luxsensor.utils.MeasurableSensor
import com.example.luxsensor.viewmodel.MainViewModel

class MainViewModelFactory(private val lightSensor: MeasurableSensor) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(lightSensor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}