package com.armenia_guide.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentCommunicationBinding
import com.armenia_guide.tools.CustomTools

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
        changeTextColorByIndex()

        showBindingCommunication?.btnNext?.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_communicationFragment_to_biometrySuccessFragment)
        }
    }


    private fun changeTextColorByIndex() {
        val textViewPrivacyPolicy = showBindingCommunication?.textPrivacyPolicy

        var textChangeColor = CustomTools.refactorColorText(
            requireContext(),
            textViewPrivacyPolicy,
            R.color.color_red,
            11,
            26
        )
        textViewPrivacyPolicy?.text = textChangeColor
        textChangeColor = CustomTools.refactorColorText(
            requireContext(),
            textViewPrivacyPolicy,
            R.color.color_red,
            29,
            textViewPrivacyPolicy?.text?.length ?: 10
        )
        textViewPrivacyPolicy?.text = textChangeColor
    }
}