package com.armenia_guide

import android.app.Application
import com.armenia_guide.model.LocalDataCountryPhoneNumberCodeImpl
import com.armenia_guide.model.Repository
import com.armenia_guide.ui.personal_area.ListPersonalAreaImpl
import com.armenia_guide.ui.personal_area.RepositoryPersonalArea
import com.armenia_guide.view_models.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ArmeniaGuideApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val moduleAuthorizationAndBiometry = module {

            single<Repository> {
                LocalDataCountryPhoneNumberCodeImpl(context = get())
            }

            single {

                AuthorizationUserViewModel(repo = get())

            }
            viewModel {
                BiometryFaceAndPassportDetectViewModel()
            }


        }

//        val moduleAuthorizationPin = module {
//            viewModel {
//                AuthorizationPinViewModel()
//            }
//        }

        val moduleSendData = module {
            single {
                AuthorizationPinViewModel()
            }
            single {
                SendBarcodeViewModel()
            }
        }
        val modulePersonalArea = module {
            single {
                PersonalAreaViewModel(repositoryPersonalArea = get())
            }

            single<RepositoryPersonalArea> {
                ListPersonalAreaImpl()
            }
        }

        startKoin (){
            androidContext(applicationContext)
            modules(
                moduleAuthorizationAndBiometry,
//                moduleAuthorizationPin,
                moduleSendData,
                modulePersonalArea
            )
        }
    }
}