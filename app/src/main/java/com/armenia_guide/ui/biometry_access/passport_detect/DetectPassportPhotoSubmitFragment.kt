package com.armenia_guide.ui.biometry_access.passport_detect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentDetectPassportPhotoSubmitBinding
import com.armenia_guide.view_models.BiometryFaceAndPassportDetectViewModel


class DetectPassportPhotoSubmitFragment : Fragment() {
    private var showBindingPassportSubmit: FragmentDetectPassportPhotoSubmitBinding? = null
    private val sharedViewModel: BiometryFaceAndPassportDetectViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingPassportSubmit = FragmentDetectPassportPhotoSubmitBinding.inflate(inflater)
        return showBindingPassportSubmit?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.passportPhotoDetectUri.observe(viewLifecycleOwner, { uriPassportPhoto ->
            showBindingPassportSubmit?.passportImageView?.setImageURI(uriPassportPhoto)
        })
        showBindingPassportSubmit?.btnRetake?.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_detectPassportPhotoSubmitFragment_to_detectPassportPhotoFragment)

        }
        showBindingPassportSubmit?.btnSubmit?.setOnClickListener {
            findNavController().navigate(R.id.action_detectPassportPhotoSubmitFragment_to_detectPassportSubmitFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        showBindingPassportSubmit = null
    }
}