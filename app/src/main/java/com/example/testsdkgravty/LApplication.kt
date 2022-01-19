package com.example.testsdkgravty

import android.app.Application
import com.gravty.sdk.GravtySDK

class LApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GravtySDK.init(this)
    }
}
