package com.armenia_guide.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.armenia_guide.R
import com.armenia_guide.view_models.AuthorizationAndBiometryViewModel
import com.armenia_guide.view_models.AuthorizationPinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class MainActivity : AppCompatActivity(), KoinComponent {
    val sharedViewModel: AuthorizationAndBiometryViewModel by viewModel()
    val sendPinViewModel: AuthorizationPinViewModel by viewModel()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }
}