package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPassportBinding
import com.armenia_guide.tools.ConstantsTools.USER_PASSPORT
import com.armenia_guide.tools.TabLayoutUserInformation

class PassportFragment : Fragment() {
    private lateinit var bindingPassport: FragmentPassportBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bindingPassport = FragmentPassportBinding.inflate(layoutInflater)

        TabLayoutUserInformation.tabLayoutFragments(bindingPassport.tabLayoutUserInformation)

        return bindingPassport.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingPassport.tabLayoutUserInformation.getTabAt(USER_PASSPORT)?.select()

        bindingPassport.btnNext.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_passportFragment_to_communicationFragment)
        }

        bindingPassport.btnClose.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
    }
}