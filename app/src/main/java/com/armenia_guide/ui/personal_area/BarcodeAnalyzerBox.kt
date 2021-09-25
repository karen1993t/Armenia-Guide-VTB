package com.armenia_guide.ui.personal_area

import android.annotation.SuppressLint
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage

open class BarcodeAnalyzerBox(private val barcodeRect: BarcodeBox) : ImageAnalysis.Analyzer {


    private val scanner = BarcodeScanning.getClient()


    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)

            scanner.process(image)

                .addOnSuccessListener { barcodes ->
                    for (barcode in barcodes) {
                        barcodeRect(barcode.boundingBox)

                    }
                }
                .addOnFailureListener {

                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        }
    }
}