package com.armenia_guide.analyzer

import android.annotation.SuppressLint
import android.opengl.Matrix
import android.se.omapi.Session
import android.util.Log
import android.util.Size
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.core.graphics.rotationMatrix
import androidx.core.graphics.scaleMatrix
import androidx.lifecycle.Lifecycle
import com.armenia_guide.ui.biometry_access.face_detect.FaceDetectListenerRect
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.*
import java.util.*


class FaceDetectAnalyzer(val lifecycle: Lifecycle, private val faceOverlayView: FaceOverlayView) :
    ImageAnalysis.Analyzer {
    // creating face detect options
    private val optionsFaceDetect = FaceDetectorOptions.Builder()
        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
        .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
        .setContourMode(FaceDetectorOptions.CONTOUR_MODE_ALL)
        .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
        .setMinFaceSize(0.5f)
        .build()
    private val faceDetectScanner = FaceDetection.getClient(optionsFaceDetect)

    init {
        lifecycle.addObserver(faceDetectScanner)
    }

    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(imageProxy: ImageProxy) {
        faceOverlayView.setPreviewSize(Size(imageProxy.width, imageProxy.height))
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val inputImage =
                InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)

            faceDetectScanner.process(inputImage).addOnSuccessListener { faceDetect ->

                  Log.d("TAGs", "Number of face detected: " + faceDetect.size)
                    faceOverlayView.setFaces(faceDetect)


//                    if (face.headEulerAngleY > 36) {
//                        Log.e("TAGs", "aj")
////                        Log.e("TAGs", "Right eye open probability ${face.rightEyeOpenProbability}")
//                    } else if (face.headEulerAngleY < -36) {
//                        Log.e("TAGs", "dzax")
//                    }
//                    Log.e("TAGs", "${face.smilingProbability}")


                }

                .addOnFailureListener { e ->
                    Log.e("ImageAnalyzer", "Face analysis failure.", e)
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        }
    }

    fun arCore (){


    }

}