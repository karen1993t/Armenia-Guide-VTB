package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentLegalAddressBinding
import com.armenia_guide.tools.ConstantsTools.USER_ADDRESS
import com.armenia_guide.tools.TabLayoutUserInformation

class LegalAddressFragment : Fragment() {
    private lateinit var bindingLegalAddress: FragmentLegalAddressBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bindingLegalAddress = FragmentLegalAddressBinding.inflate(layoutInflater)

        TabLayoutUserInformation.tabLayoutFragments(bindingLegalAddress.tabLayoutUserInformation)

        return bindingLegalAddress.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingLegalAddress.tabLayoutUserInformation.getTabAt(USER_ADDRESS)?.select()

        bindingLegalAddress.btnNext.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_legalAddressFragment_to_passportFragment)
        }

        bindingLegalAddress.btnClose.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
    }
}