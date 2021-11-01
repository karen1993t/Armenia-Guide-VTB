package com.armenia_guide.ui.biometry_access.face_detect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentFaceDetectVideoFailureBinding
import com.google.android.material.snackbar.Snackbar

class FaceDetectVideoFailureFragment : Fragment() {
    private val bindingFaceDetectFailure by lazy {
        FragmentFaceDetectVideoFailureBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingFaceDetectFailure.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingFaceDetectFailure.btnRetake.setOnClickListener {
            findNavController().navigate(R.id.action_faceDetectVideoFailureFragment_to_faceDetectVideoFragment)
        }

    }
}