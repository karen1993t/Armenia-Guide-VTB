package com.armenia_guide.ui.personal_area

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.armenia_guide.databinding.FragmentPayBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

typealias BarcodeListener = (barcode: String) -> Unit
typealias BarcodeBox = (rect: Rect) -> Unit


class PayFragment : Fragment() {
    private var bindingPayFragment: FragmentPayBinding? = null
    private lateinit var cameraExecutor: ExecutorService
    private var processingBarcode = AtomicBoolean(false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cameraExecutor = Executors.newSingleThreadExecutor()
        bindingPayFragment = FragmentPayBinding.inflate(inflater)
        return bindingPayFragment?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    private fun startCamera() {

        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({

            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()


            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(
                    bindingPayFragment?.fragmentScanBarcodePreviewView?.surfaceProvider
                )
            }

            val imageAnalysis = ImageAnalysis.Builder()
                .build()
                .also {

                    it.setAnalyzer(cameraExecutor, BarcodeAnalyzerBox() { rect ->

                        if (rect.height() <= bindingPayFragment?.surfaceView!!.height &&
                            rect.width() <= bindingPayFragment?.surfaceView!!.width

                        ) {
                            it.setAnalyzer(cameraExecutor, BarcodeAnalyzer() { barcode ->

                                if (processingBarcode.compareAndSet(false, true)) {

                                    Toast.makeText(requireContext(), "$barcode", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            })
                        }

                        Toast.makeText(requireContext(), "${rect.width()}", Toast.LENGTH_SHORT).show()

                    })

                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            try {
                // Unbind any bound use cases before rebinding
                cameraProvider.unbindAll()
                // Bind use cases to lifecycleOwner
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

    override fun onDestroyView() {
        super.onDestroyView()
        bindingPayFragment = null
    }

}