package com.armenia_guide.biometry_access

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentBiometryVideoBinding
import com.google.android.material.snackbar.Snackbar

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
                Snackbar.make(requireContext(),view,"camera Preview",Snackbar.LENGTH_SHORT).show()

            }
        showBindingBiometryVideo?.btnNextToBiometry?.setOnClickListener {
            showBindingBiometryVideo?.btnNextToBiometry?.alpha = 0.1f
            permissionCamera.launch(Manifest.permission.CAMERA)
        }
    }
}