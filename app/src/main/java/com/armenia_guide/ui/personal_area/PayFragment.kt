package com.armenia_guide.ui.personal_area

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.GREEN
import android.graphics.Paint
import android.icu.lang.UCharacter.IndicPositionalCategory.*
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity.TOP
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.analyzer.BarcodeAnalyzer
import com.armenia_guide.databinding.FragmentPayBinding
import com.armenia_guide.view_models.SendBarcodeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

typealias BarcodeListener = (barcode: String) -> Unit

class PayFragment : Fragment() {
    private val bindingPay by lazy {
        FragmentPayBinding.inflate(layoutInflater)
    }
    private lateinit var cameraExecutor: ExecutorService
    private var processingBarcode = AtomicBoolean(false)
    val viewModel:SendBarcodeViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        cameraExecutor = Executors.newSingleThreadExecutor()
        return bindingPay.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // bindingPay.surfaceView.background.colorFilter

        val requestPermissions =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {}

        if (allPermissionsGranted()) {
            startCamera()
        } else {
            requestPermissions.launch(
                arrayOf(Manifest.permission.CAMERA)
            )
            startCamera()
        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun startCamera() {

        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({

            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(
                    bindingPay.fragmentScanBarcodePreviewView.surfaceProvider
                )
            }


            val imageAnalysis = ImageAnalysis.Builder()
                .build()
                .also {
                    it.setAnalyzer(cameraExecutor, BarcodeAnalyzer() { barcode ->

                        if (processingBarcode.compareAndSet(false, true)) {
                          // CustomRectangleCutoutView(requireContext()).framePaint.color = GREEN

                            findNavController().navigate(R.id.action_payFragment_to_searchedBarcodeFragment)
                            viewModel.sendBarcode(barcode)
                        }
                    })
                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalysis)
            } catch (e: Exception) {
                Log.e("PreviewUseCase", "Binding failed! :(", e)
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }



    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            requireContext(), it
        ) == PackageManager.PERMISSION_GRANTED
    }

    companion object {
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }
}