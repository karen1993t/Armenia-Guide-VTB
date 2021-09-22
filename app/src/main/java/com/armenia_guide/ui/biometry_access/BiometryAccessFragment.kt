package com.armenia_guide.ui.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentBiometryAccessBinding
import com.armenia_guide.tools.RefactorTextColorsTools
import com.armenia_guide.view_models.AuthorizationAndBiometryViewModel



class BiometryAccessFragment : Fragment() {
    private var showBindingBiometryAccess: FragmentBiometryAccessBinding? = null
    private val sharedViewModel: AuthorizationAndBiometryViewModel by activityViewModels()
    private var textErrorToast = "error"


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
        textErrorToast = resources.getString(R.string.text_toast_error_privacy_policy)
        changeTextColorByIndex()


        showBindingBiometryAccess?.btnNext?.setOnClickListener {
            val isChecked = showBindingBiometryAccess?.checkBoxPrivacyPolicy?.isChecked
            if (isChecked == true) Navigation.findNavController(view)

                .navigate(R.id.action_biometryAccessFragment_to_personalInformationFragment)
            else Toast.makeText(
                requireContext(),
                textErrorToast,
                Toast.LENGTH_SHORT
            ).show()


        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        showBindingBiometryAccess = null
    }


    private fun changeTextColorByIndex() {
        val textViewPrivacyPolicy = showBindingBiometryAccess?.textPrivacyPolicy

        var textChangeColor = RefactorTextColorsTools.refactorColorText(
            requireContext(),
            textViewPrivacyPolicy,
            R.color.color_red,
            11,
            26
        )
        textViewPrivacyPolicy?.text = textChangeColor
        textChangeColor = RefactorTextColorsTools.refactorColorText(
            requireContext(),
            textViewPrivacyPolicy,
            R.color.color_red,
            29,
            textViewPrivacyPolicy?.text?.length ?: 10
        )
        textViewPrivacyPolicy?.text = textChangeColor
    }

}