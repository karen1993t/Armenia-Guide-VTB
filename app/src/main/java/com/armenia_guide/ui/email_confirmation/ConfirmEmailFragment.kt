package com.armenia_guide.ui.email_confirmation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentConfirmEmailBinding
import com.armenia_guide.tools.RefactorTextColorsTools


class ConfirmEmailFragment : Fragment() {
    private val showBindingConfirmEmail by lazy { FragmentConfirmEmailBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return showBindingConfirmEmail.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBindingConfirmEmail.btnStart.isActivated = false
        showBindingConfirmEmail.textPrivacyPolicy.text =
            RefactorTextColorsTools.textPrivacyPolicy(requireContext())

        showBindingConfirmEmail.checkBoxPrivacyPolicy.setOnCheckedChangeListener { _, isChecked ->
            isCheckPrivacyPolicy(isChecked)
        }

        showBindingConfirmEmail.btnStart.setOnClickListener {
            if (showBindingConfirmEmail.btnStart.isActivated) {
                findNavController().navigate(R.id.action_confirmEmailFragment_to_confirmEmailFocusInputFragment)
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun isCheckPrivacyPolicy(isChecked: Boolean) {
        when (isChecked) {
            true -> {
                showBindingConfirmEmail.btnStart.background =
                    resources.getDrawable(R.drawable.background_button_red, null)
                showBindingConfirmEmail.btnStart.isActivated = true
            }
            false -> {
                showBindingConfirmEmail.btnStart.background =
                    resources.getDrawable(R.drawable.background_button_gray, null)
                showBindingConfirmEmail.btnStart.isActivated = false
            }
        }
    }
}