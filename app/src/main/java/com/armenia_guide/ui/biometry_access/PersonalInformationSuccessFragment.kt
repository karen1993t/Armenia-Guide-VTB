package com.armenia_guide.ui.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentBiometrySuccessBinding


class PersonalInformationSuccessFragment : Fragment() {
    private var showBiometrySuccess: FragmentBiometrySuccessBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBiometrySuccess = FragmentBiometrySuccessBinding.inflate(inflater, container, false)
        return showBiometrySuccess?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showBiometrySuccess?.btnNext?.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_biometrySuccessFragment_to_biometryAccessVideoFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        showBiometrySuccess = null
    }


}