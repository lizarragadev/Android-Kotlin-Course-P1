package dev.lizarraga.otificaciones

import android.app.Application
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "2daaa291-ceef-46e8-b38e-29934fed45b3"

class OneSignalApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        OneSignal.promptForPushNotifications()

    }
}