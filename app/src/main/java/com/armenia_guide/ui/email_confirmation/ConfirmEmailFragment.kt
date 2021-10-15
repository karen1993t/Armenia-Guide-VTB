package com.armenia_guide.ui.email_confirmation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentConfirmEmailBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.tools.RefactorTextColorsTools
import com.armenia_guide.view_models.RegisterAndLoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ConfirmEmailFragment : Fragment() {
    private val showBindingConfirmEmail by lazy { FragmentConfirmEmailBinding.inflate(layoutInflater) }
    private val sharedViewModelRegister: RegisterAndLoginViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return showBindingConfirmEmail.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /** Back To Register Fragment **/
        onBackPressed()

        /** Change Color Text Privacy Policy **/
        showBindingConfirmEmail.textPrivacyPolicy.text =
            RefactorTextColorsTools.textPrivacyPolicy(requireContext())

        showBindingConfirmEmail.checkBoxPrivacyPolicy.setOnCheckedChangeListener { _, isChecked ->
            showBindingConfirmEmail.btnStart.isActivated = isChecked
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
                showBindingConfirmEmail.btnStart.isActivated = isChecked
            }
            false -> {
                showBindingConfirmEmail.btnStart.background =
                    resources.getDrawable(R.drawable.background_button_gray, null)
                showBindingConfirmEmail.btnStart.isActivated = isChecked
            }
        }
    }

    private fun onBackPressed() {

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            sharedViewModelRegister.setPositionFragment(ConstantsTools.REGISTER_USER_POSITION)
            findNavController().popBackStack()

        }
    }
}