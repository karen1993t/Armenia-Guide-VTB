package com.armenia_guide

import android.app.Application
import com.armenia_guide.view_models.AuthorizationAndBiometryViewModel
import com.armenia_guide.view_models.AuthorizationPinViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ArmeniaGuideApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val moduleAuthorization = module {
            viewModel {
                AuthorizationAndBiometryViewModel()
            }

        }

        val moduleAuthorizationPin = module {
            viewModel {
                AuthorizationPinViewModel()
            }
        }
        startKoin {
            androidContext(applicationContext)
            modules(moduleAuthorization, moduleAuthorizationPin)
        }
    }
}