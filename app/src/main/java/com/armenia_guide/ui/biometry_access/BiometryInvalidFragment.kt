package com.armenia_guide.ui.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.armenia_guide.databinding.FragmentBiometryInvalidBinding

class BiometryInvalidFragment : Fragment() {
    private var shoBindingBiometryInvalid: FragmentBiometryInvalidBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoBindingBiometryInvalid =
            FragmentBiometryInvalidBinding.inflate(inflater, container, false)
        return shoBindingBiometryInvalid?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        shoBindingBiometryInvalid = null
    }
}