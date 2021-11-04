package com.armenia_guide.ui.biometry_access.face_detect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentFaceDetectBlankBinding

class FaceDetectBlankFragment : Fragment() {

    private lateinit var bindingFaceDetectBlank:FragmentFaceDetectBlankBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bindingFaceDetectBlank= FragmentFaceDetectBlankBinding.inflate(layoutInflater)

        return bindingFaceDetectBlank.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         bindingFaceDetectBlank.btnStart.setOnClickListener {
             findNavController().navigate(R.id.action_faceDetectBlankFragment_to_faceDetectVideoFragment)
         }
    }

}