package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentBiometrySuccessBinding

class PersonalInformationSuccessFragment : Fragment() {

    private lateinit var bindingBiometrySuccess: FragmentBiometrySuccessBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bindingBiometrySuccess = FragmentBiometrySuccessBinding.inflate(layoutInflater)

        return bindingBiometrySuccess.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingBiometrySuccess.btnNext.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_biometrySuccessFragment_to_photoPassportBlankFragment)
        }
    }
}