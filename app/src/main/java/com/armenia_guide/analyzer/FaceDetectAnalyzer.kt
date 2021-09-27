package com.vtb.vtb_project.analyzer

import android.annotation.SuppressLint
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.armenia_guide.ui.biometry_access.face_detect.FaceDetectListenerRect
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions



class FaceDetectAnalyzer(private val rect:FaceDetectListenerRect) : ImageAnalysis.Analyzer {
    // creating face detect options
    private val optionsFaceDetect = FaceDetectorOptions.Builder()
        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_FAST)
        .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
        .setContourMode(FaceDetectorOptions.CONTOUR_MODE_ALL)
        .enableTracking()
        .build()
    private val faceDetectScanner = FaceDetection.getClient(optionsFaceDetect)

    @SuppressLint("UnsafeOptInUsageError")
    override fun analyze(imageProxy: ImageProxy) {

        val mediaImage = imageProxy.image

        if (mediaImage != null) {
            val inputImage =
    //            InputImage.fromByteBuffer(mediaImage,imageWith,imageH,rotate,InputImage.IMAGE_FORMAT_YUV_420_888)
                InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)


            faceDetectScanner.process(inputImage).addOnSuccessListener { faceDetect ->
              //  Log.d("test_1", "ok")
//                isFaceDetect(false)

                for (face in faceDetect) {
//                    isFaceDetect(true)
                    rect(face.boundingBox)

                    if (face.leftEyeOpenProbability == 1.0.toFloat()) {
                        val leftEyeOpenProb = face.leftEyeOpenProbability
                        Log.d("test_1", "leftEyarOpen = ${leftEyeOpenProb}")
                    }
//                    Log.d("tests", "${face.getLandmark(FaceLandmark.LEFT_EAR)}")
                    Log.d("tests", "${face.boundingBox}")
                    imageProxy.close()
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