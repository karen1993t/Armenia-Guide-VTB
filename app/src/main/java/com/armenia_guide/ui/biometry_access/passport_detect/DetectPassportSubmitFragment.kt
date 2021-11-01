package com.armenia_guide.ui.biometry_access.passport_detect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentDetectPassportSubmitBinding

class DetectPassportSubmitFragment : Fragment() {

    private val bindingDetectPassportSubmit by lazy {
        FragmentDetectPassportSubmitBinding.inflate(
            layoutInflater
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingDetectPassportSubmit.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingDetectPassportSubmit.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_detectPassportSubmitFragment_to_faceDetectBlankFragment)
        }
    }
}