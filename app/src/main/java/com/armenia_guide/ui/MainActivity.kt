package com.armenia_guide.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.armenia_guide.R
import com.armenia_guide.view_models.AuthorizationAndBiometryViewModel
import com.armenia_guide.view_models.BiometryFaceAndPassportDetectViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel




class MainActivity : AppCompatActivity() {
    val sharedViewModel: AuthorizationAndBiometryViewModel by viewModel()
    val sharedFaceAndPassportDetectViewModel: BiometryFaceAndPassportDetectViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}