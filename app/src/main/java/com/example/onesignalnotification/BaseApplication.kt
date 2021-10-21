package com.example.onesignalnotification

import android.app.Application
import com.onesignal.OneSignal

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONE_SIGNAL_APP_ID)
    }

    companion object {
        const val ONE_SIGNAL_APP_ID = "548ce7e9-4a92-40f1-92ba-4df7348f6019"
    }

}