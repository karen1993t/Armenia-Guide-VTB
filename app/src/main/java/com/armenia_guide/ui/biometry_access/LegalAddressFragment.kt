package com.armenia_guide.ui.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentLegalAddressBinding

class LegalAddressFragment : Fragment() {
    private var showBindingLegalAddress: FragmentLegalAddressBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingLegalAddress = FragmentLegalAddressBinding.inflate(inflater, container, false)
        return showBindingLegalAddress?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBindingLegalAddress?.btnNext?.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_legalAddressFragment_to_passportFragment)
        }
    }
}