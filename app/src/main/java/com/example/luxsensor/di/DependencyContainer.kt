package com.example.luxsensor.di

import android.content.Context
import android.hardware.SensorManager
import com.example.luxsensor.factory.MainViewModelFactory
import com.example.luxsensor.utils.LightSensor
import com.example.luxsensor.utils.MeasurableSensor



class DependencyContainer(
 private val appContext: Context
){
    val lightSensor: MeasurableSensor = LightSensor(appContext)

    val mainViewModelFactory:MainViewModelFactory=MainViewModelFactory(lightSensor)

}


