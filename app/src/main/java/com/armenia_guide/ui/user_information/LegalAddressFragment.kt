package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentLegalAddressBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.view_models.PositionTabLayoutViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LegalAddressFragment : Fragment() {
    private lateinit var showBindingLegalAddress: FragmentLegalAddressBinding
    private val getPositionTabLayoutViewModel: PositionTabLayoutViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        showBindingLegalAddress = FragmentLegalAddressBinding.inflate(inflater, container, false)
        return showBindingLegalAddress.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBindingLegalAddress.btnNext.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_legalAddressFragment_to_passportFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        getPositionTabLayoutViewModel.sendPositionTabLayout(ConstantsTools.USER_ADDRESS)
    }
}