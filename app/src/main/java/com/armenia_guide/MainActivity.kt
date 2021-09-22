package com.armenia_guide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.armenia_guide.view_models.AuthorizationAndBiometryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class MainActivity : AppCompatActivity(), KoinComponent {
    val sharedViewModel: AuthorizationAndBiometryViewModel by viewModel()


    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val viewModel = ViewModelProvider(this).get(CustomViewModel::class.java)
        }
    }
}