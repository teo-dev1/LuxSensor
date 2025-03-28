package com.example.luxsensor

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.luxsensor.di.SensorApp
import com.example.luxsensor.di.SensorApp.Companion.appDependencyContainer
import com.example.luxsensor.factory.MainViewModelFactory
import com.example.luxsensor.utils.MeasurableSensor
import com.example.luxsensor.viewmodel.BrightnessState
import com.example.luxsensor.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel= ViewModelProvider(this,appDependencyContainer.mainViewModelFactory).get(MainViewModel::class.java)
    private val colorMap= mapOf(
        BrightnessState.BRIGHT to "#ffffff",
        BrightnessState.QUITE_BRIGHT to "#b1b3b5",
        BrightnessState.QUITE_DARK to "#656566",
        BrightnessState.DARK to "#000000"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModelObserver()
    }




    fun setUpViewModelObserver(){
        viewModel.state.observe(this){brightnessState ->
            background.setBackgroundColor(Color.parseColor(colorMap[brightnessState]))
        }
    }


}