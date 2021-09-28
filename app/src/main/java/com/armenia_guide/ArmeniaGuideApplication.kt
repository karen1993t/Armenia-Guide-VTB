package com.armenia_guide

import android.app.Application
import com.armenia_guide.view_models.AuthorizationAndBiometryViewModel
import com.armenia_guide.view_models.AuthorizationPinViewModel
import com.armenia_guide.view_models.BiometryFaceAndPassportDetectViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ArmeniaGuideApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val moduleAuthorizationAndBiometry = module {
            viewModel {
                AuthorizationAndBiometryViewModel()

            }
            viewModel {
                BiometryFaceAndPassportDetectViewModel()
            }

        }

        val moduleAuthorizationPin = module {
            viewModel {
                AuthorizationPinViewModel()
            }
        }

        startKoin {
            androidContext(applicationContext)
            modules(moduleAuthorizationAndBiometry, moduleAuthorizationPin)
        }
    }
}