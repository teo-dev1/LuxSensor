package com.example.luxsensor.di

import android.app.Application

class SensorApp: Application() {

    companion object{
        lateinit var appDependencyContainer:DependencyContainer
    }

    override fun onCreate() {
        super.onCreate()
        appDependencyContainer=DependencyContainer(this)
    }
}