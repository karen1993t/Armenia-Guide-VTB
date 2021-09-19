package com.armenia_guide.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentBiometryAccessBinding
import com.armenia_guide.tools.CustomTools

class BiometryAccessFragment : Fragment() {
    private var showBindingBiometryAccess: FragmentBiometryAccessBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingBiometryAccess =
            FragmentBiometryAccessBinding.inflate(inflater, container, false)
        return showBindingBiometryAccess?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeTextColorByIndex()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        showBindingBiometryAccess = null
    }







    private fun changeTextColorByIndex() {
        val textViewPrivacyPolicy = showBindingBiometryAccess?.textPrivacyPolicy

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