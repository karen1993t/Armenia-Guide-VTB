package com.armenia_guide.ui.biometry_access.face_detect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentFaceDetectSuccessBinding

class FaceDetectSuccessFragment : Fragment() {

    private val bindingFaceDetectVideoSuccess by lazy {
        FragmentFaceDetectSuccessBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingFaceDetectVideoSuccess.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingFaceDetectVideoSuccess.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_faceDetectSuccessFragment_to_answerFragment)
        }
    }
}