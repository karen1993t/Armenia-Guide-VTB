package com.armenia_guide.ui.biometry_access.face_detect

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.ImageFormat
import android.graphics.Rect
import android.media.MediaCodec


import android.media.MediaRecorder
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Vibrator
import android.util.DisplayMetrics
import android.util.Rational
import android.util.Size
import android.view.*
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.*
import androidx.camera.core.impl.VideoCaptureConfig
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.armenia_guide.databinding.FragmentFaceDetectVideoBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.R
import com.armenia_guide.tools.getAspectRatio
import com.armenia_guide.view_models.BiometryFaceAndPassportDetectViewModel
import com.vtb.vtb_project.analyzer.FaceDetectAnalyzer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.io.File
import java.util.Date
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


typealias FaceDetectListener = (isDetect: Boolean) -> Unit
typealias FaceDetectListenerRect = (rect: Rect) -> Unit


class FaceDetectVideoFragment : Fragment(), View.OnClickListener {

    private var isRecording = false
    private lateinit var currentVideoPath: String
    private lateinit var uri: Uri
    private val showBindingCamera by lazy { FragmentFaceDetectVideoBinding.inflate(layoutInflater) }
    private val sharedViewModel: BiometryFaceAndPassportDetectViewModel by activityViewModels()
    private var videoCapture: VideoCapture? = null
    lateinit var videoCaptureTakeVideo: VideoCapture
    private var imageCapture: ImageCapture? = null
    private val cameraExecutor by lazy { ContextCompat.getMainExecutor(requireContext()) }
    private lateinit var videoFile: File
    private val screenAspectRatio by lazy {
        val metrics =
            DisplayMetrics().also { showBindingCamera.scanFacePreviewView.display.getRealMetrics(it) }
        metrics.getAspectRatio()
    }

    private var vibrator: Vibrator? = null

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uri = Uri.parse("")
//        cameraExecutor = Executors.newSingleThreadExecutor()
        videoCapture = VideoCapture.Builder().build()
        imageCapture = ImageCapture.Builder().build()
        videoCapture = VideoCapture.Builder().build()


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return showBindingCamera.root
    }

    @SuppressLint("UseCompatLoadingForDrawables", "RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val requestPermission =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { isGrantedMap ->
                var isPermissionCameraGranted = false
                var isPermissionAudioGranted = false
                var isPermissionWriteExternalStorageGranted = false
                var isPermissionReadExternalStorageGranted = false
                for (entry in isGrantedMap) {
                    when (entry.key) {
                        Manifest.permission.CAMERA -> {
                            isPermissionCameraGranted = entry.value
                        }
                        Manifest.permission.RECORD_AUDIO -> {
                            isPermissionAudioGranted = entry.value
                        }

                        Manifest.permission.WRITE_EXTERNAL_STORAGE -> {
                            isPermissionWriteExternalStorageGranted = entry.value
                        }
                        Manifest.permission.READ_EXTERNAL_STORAGE -> {
                            isPermissionReadExternalStorageGranted = entry.value
                        }
                    }
                }
                if (isPermissionCameraGranted && isPermissionAudioGranted &&
                    isPermissionReadExternalStorageGranted && isPermissionWriteExternalStorageGranted
                ) startCamera()
                else Toast.makeText(
                    requireContext(), "Permissions not granted by the user.",
                    Toast.LENGTH_SHORT
                ).show()

            }
        requestPermission.launch(
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,

                )
        )
        showBindingCamera.cameraCaptureButton.setOnClickListener(this)
        showBindingCamera.btnBack.setOnClickListener(this)
        showBindingCamera.btnClose.setOnClickListener(this)


    }

    @SuppressLint("UseCompatLoadingForDrawables", "UnsafeOptInUsageError")
    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        val cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA
        val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

        val previewUseCase =
            Preview.Builder()
                .setTargetRotation(showBindingCamera.scanFacePreviewView.display.rotation)
                .setTargetAspectRatio(screenAspectRatio)
                .build()
//                .also {
//                    it.setSurfaceProvider(showBindingCamera.scanFacePreviewView.surfaceProvider)
//                }


        cameraProviderFuture.addListener({


            val imageAnalysisUseCase = ImageAnalysis.Builder()
                .setTargetRotation(showBindingCamera.scanFacePreviewView.display.rotation)
                .setTargetResolution(Size(400, 400))
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()
                .also {
                    it.setAnalyzer(cameraExecutor, FaceDetectAnalyzer {
                        if (showBindingCamera.faceDetectBox.top > it.top &&
                            showBindingCamera.faceDetectBox.left > it.left &&
                            showBindingCamera.faceDetectBox.right > it.right &&
                            showBindingCamera.faceDetectBox.bottom > it.bottom
                        ) {
                            showBindingCamera.faceDetectBox.background = resources.getDrawable(
                                R.drawable.background_face_detect_success,
                                null
                            )
                            vibrator = requireContext().getSystemService<Vibrator>()
                            vibrator?.vibrate(1)

                        } else {
                            showBindingCamera.faceDetectBox.background = resources.getDrawable(
                                R.drawable.background_face_detect,
                                null
                            )
                            vibrator?.cancel()

                        }

                    })

                }
            val aspectRatio = Rational(
                showBindingCamera.scanFacePreviewView.width,
                showBindingCamera.scanFacePreviewView.height
            )


            val viewPort = ViewPort.Builder(
                aspectRatio,
                showBindingCamera.scanFacePreviewView.display.rotation
            ).build()


            val useCaseGroup = UseCaseGroup.Builder().apply {
                addUseCase(previewUseCase)
//                addUseCase(imageAnalysisUseCase)
                addUseCase(videoCapture!!)
                setViewPort(viewPort)
            }.build()



            try {
                cameraProvider.unbindAll()
                val camera = cameraProvider.bindToLifecycle(
                    viewLifecycleOwner,
                    cameraSelector,
                    useCaseGroup
                )

                previewUseCase.setSurfaceProvider(
                    cameraExecutor,
                    showBindingCamera.scanFacePreviewView.surfaceProvider
                )
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Filed Camera !", Toast.LENGTH_SHORT).show()
            }

        }, cameraExecutor)
    }

    @SuppressLint("RestrictedApi")
    private fun takeVideo() {
        videoCaptureTakeVideo = videoCapture ?: return
        CoroutineScope(Dispatchers.IO).launch {
            videoFile = createVideoFile()
            val outputOptions = VideoCapture.OutputFileOptions.Builder(videoFile).build()
            videoCaptureTakeVideo.startRecording(
                outputOptions,
                ContextCompat.getMainExecutor(requireContext()),
                object : VideoCapture.OnVideoSavedCallback {
                    override fun onVideoSaved(outputFileResults: VideoCapture.OutputFileResults) {
                        try {
                            uri = FileProvider.getUriForFile(
                                requireContext(),
                                com.armenia_guide.BuildConfig.APPLICATION_ID + ".provider",
                                videoFile
                            )
                            sharedViewModel.setUriVideoDetect(uri)
                            findNavController().navigate(R.id.action_faceDetectVideoFragment_to_detectVideoSubmitFragment)


                        } catch (e: Exception) {
                            findNavController().navigate(R.id.action_faceDetectVideoFragment_to_faceDetectVideoFailureFragment)
                        }
                    }

                    override fun onError(
                        videoCaptureError: Int,
                        message: String,
                        cause: Throwable?
                    ) {
                        findNavController().navigate(R.id.action_faceDetectVideoFragment_to_faceDetectVideoFailureFragment)

                    }
                })
        }

    }

    @SuppressLint("SimpleDateFormat")
    fun createVideoFile(): File {
        val timeStamp: String = SimpleDateFormat(ConstantsTools.FILENAME_DATE_FORMAT).format(Date())
        val storageDir: File? = activity?.getExternalFilesDir(Environment.DIRECTORY_DCIM)
        return File.createTempFile(
            "Biometric_Video_${timeStamp}",
            ".3gp",
            storageDir
        ).apply {
            currentVideoPath = absolutePath
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables", "RestrictedApi")
    override fun onClick(view: View?) {

        when (view) {
            showBindingCamera.cameraCaptureButton -> {
                when (isRecording) {
                    false -> {
                        takeVideo()
                        showBindingCamera.cameraCaptureButton.background =
                            resources.getDrawable(R.drawable.ic_background_stop_video_button, null)
                        isRecording = true
                    }
                    true -> {
                        videoCaptureTakeVideo.stopRecording()
                        showBindingCamera.cameraCaptureButton.background =
                            resources.getDrawable(
                                R.drawable.ic_background_video_capture_button,
                                null
                            )
                        isRecording = false
                    }
                }
            }
            showBindingCamera.btnBack -> showBindingCamera.root.let {
                findNavController().navigate(R.id.action_faceDetectVideoFragment_to_biometryVideoFragment)
            }
            showBindingCamera.btnClose -> showBindingCamera.root.let {
                findNavController().navigate(R.id.action_faceDetectVideoFragment_to_biometryAccessVideoFragment)
            }
        }
    }


}