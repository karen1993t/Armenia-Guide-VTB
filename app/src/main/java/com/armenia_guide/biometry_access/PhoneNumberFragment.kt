package com.armenia_guide.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPhoneNumberBinding

class PhoneNumberFragment : Fragment() {
    private var showBindingPhoneNumber: FragmentPhoneNumberBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingPhoneNumber = FragmentPhoneNumberBinding.inflate(inflater, container, false)
        return showBindingPhoneNumber?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBindingPhoneNumber?.btnNext?.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_phoneNumberFragment_to_legalAddressFragment)
        }
    }
}