package com.example.luxsensor.utils

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

abstract class AndroidSensor(
    private val context: Context,
    private val sensorFeature:String,
    sensorType:Int
):MeasurableSensor(sensorType),SensorEventListener{

    override val doesItExist: Boolean
        get() = context.packageManager.hasSystemFeature(sensorFeature)

    private lateinit var sensorManager: SensorManager
    private var sensor:Sensor?=null
    override fun startListening() {
        println("inizio")
        if(!doesItExist){
          return
        }
        if(!::sensorManager.isInitialized && sensor== null){
            sensorManager= context.getSystemService(SensorManager::class.java) as SensorManager
            sensor=sensorManager.getDefaultSensor(sensorType)
        }
        sensor?.let {
            sensorManager.registerListener(this,it,SensorManager.SENSOR_DELAY_NORMAL)
        }
    }
    override fun stopListening() {
        if(!doesItExist || !::sensorManager.isInitialized){
            return
        }
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(!doesItExist){
            return
        }
        if(event?.sensor?.type==sensorType){
            onSensorValuesChanged?.invoke(event?.values.toList())
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}