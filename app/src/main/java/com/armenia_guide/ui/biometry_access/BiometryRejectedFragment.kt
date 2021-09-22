package com.armenia_guide.ui.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.armenia_guide.databinding.FragmentBiometryRejectedBinding

class BiometryRejectedFragment : Fragment() {
    private var showBindingBiometryReject: FragmentBiometryRejectedBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingBiometryReject =
            FragmentBiometryRejectedBinding.inflate(inflater, container, false)
        return showBindingBiometryReject?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showBindingBiometryReject = null
    }
}