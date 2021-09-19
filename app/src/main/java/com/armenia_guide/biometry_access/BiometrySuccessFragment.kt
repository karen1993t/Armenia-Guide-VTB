package com.armenia_guide.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.databinding.FragmentBiometrySuccessBinding


class BiometrySuccessFragment : Fragment() {
    private var showBiometrySuccess: FragmentBiometrySuccessBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBiometrySuccess = FragmentBiometrySuccessBinding.inflate(inflater, container, false)
        return showBiometrySuccess?.root
    }


}