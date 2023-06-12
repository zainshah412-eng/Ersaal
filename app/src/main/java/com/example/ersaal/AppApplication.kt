package com.example.ersaal

import android.app.Application
import com.example.ersaal.utils.SessionManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppApplication: Application() {
    private val TAG = AppApplication::class.simpleName
    companion object {
        lateinit var instance: Application
        lateinit var sessionManager: SessionManager

    }

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        instance = this
        sessionManager = SessionManager(applicationContext)

    }
    override fun onTerminate() {
        super.onTerminate()
    }


}