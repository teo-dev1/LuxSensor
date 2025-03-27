package com.example.luxsensor.viewmodel

import androidx.lifecycle.ViewModel
import com.example.luxsensor.utils.LightSensor
import com.example.luxsensor.utils.MeasurableSensor


class MainViewModel(
    private val lightSensor: MeasurableSensor
):ViewModel(){
    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values->
            val lux = values[0]
            println("EEE ->$lux")
        }
    }
}