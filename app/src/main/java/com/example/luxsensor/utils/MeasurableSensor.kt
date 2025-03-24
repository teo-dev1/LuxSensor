package com.example.luxsensor.utils

abstract class MeasurableSensor(
    protected val sensorType:Int
) {
    protected var onSensorValuesChanged : ((List<Float>) -> Unit)?=null
    fun setOnSensorValuesChangedListener(listener:(List<Float>)->Unit){
        onSensorValuesChanged=listener
    }
    abstract val doesItExist:Boolean
    abstract fun startListening()
    abstract fun stopListening()
}