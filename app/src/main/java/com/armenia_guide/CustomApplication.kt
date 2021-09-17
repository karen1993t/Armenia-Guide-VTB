package com.armenia_guide

import android.app.Application
import com.armenia_guide.authorization.AuthorizationRepeatPinFragment
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val customModule = module {

        }
        startKoin {
            androidContext(applicationContext)
            modules(customModule)
        }

    }


}