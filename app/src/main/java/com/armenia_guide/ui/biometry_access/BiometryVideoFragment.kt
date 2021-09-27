package com.armenia_guide.ui.biometry_access

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentBiometryVideoBinding


class BiometryVideoFragment : Fragment() {
    private var showBindingBiometryVideo: FragmentBiometryVideoBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingBiometryVideo = FragmentBiometryVideoBinding.inflate(inflater, container, false)
        return showBindingBiometryVideo?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val permissionCamera =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {
               Navigation.findNavController(view).navigate(R.id.action_biometryVideoFragment_to_faceDetectVideoFragment)

            }
        showBindingBiometryVideo?.btnNextToBiometry?.setOnClickListener {
            showBindingBiometryVideo?.btnNextToBiometry?.alpha = 0.1f
            permissionCamera.launch(Manifest.permission.CAMERA)
        }
    }
}