package com.armenia_guide.ui.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.armenia_guide.databinding.FragmentBiometryRejectedBinding

class BiometryRejectedFragment : Fragment() {
    private val showBindingBiometryReject by lazy {  FragmentBiometryRejectedBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return showBindingBiometryReject.root
    }

}