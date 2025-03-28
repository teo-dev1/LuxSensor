package com.example.luxsensor.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.luxsensor.utils.LightSensor
import com.example.luxsensor.utils.MeasurableSensor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class MainViewModel(
    private val lightSensor: MeasurableSensor
):ViewModel() {
    private var _state = MutableLiveData<BrightnessState>()
    val state: LiveData<BrightnessState> get() = _state

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values ->
            val lux = values[0]
            _state.value = when {
                lux < 50f -> BrightnessState.DARK
                lux in 51..120 -> BrightnessState.QUITE_DARK
                lux in 121..180 -> BrightnessState.QUITE_BRIGHT
                lux > 180 -> BrightnessState.BRIGHT

                else -> {BrightnessState.BRIGHT}
            }
        }
    }
}


sealed class BrightnessState(){
    object BRIGHT:BrightnessState()
    object QUITE_BRIGHT:BrightnessState()
    object QUITE_DARK:BrightnessState()
    object DARK:BrightnessState()
}

