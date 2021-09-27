package com.armenia_guide.ui.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentCommunicationBinding
import com.armenia_guide.tools.RefactorTextColorsTools

class CommunicationFragment : Fragment() {
    private var showBindingCommunication: FragmentCommunicationBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingCommunication = FragmentCommunicationBinding.inflate(inflater, container, false)
        return showBindingCommunication?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        showBindingCommunication?.btnNext?.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_communicationFragment_to_biometrySuccessFragment)
        }
    }



}