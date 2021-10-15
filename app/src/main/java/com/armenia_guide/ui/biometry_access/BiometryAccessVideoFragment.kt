package com.armenia_guide.ui.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentBiometryAccessVideoBinding

class BiometryAccessVideoFragment : Fragment() {
    private var showBindingBiometryVideo: FragmentBiometryAccessVideoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingBiometryVideo =
            FragmentBiometryAccessVideoBinding.inflate(inflater, container, false)
        return showBindingBiometryVideo?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBindingBiometryVideo?.btnNext?.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_biometryAccessVideoFragment_to_biometryVideoFragment)
        }
    }
}