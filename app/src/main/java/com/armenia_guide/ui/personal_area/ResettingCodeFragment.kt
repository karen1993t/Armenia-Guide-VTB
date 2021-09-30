package com.armenia_guide.ui.personal_area

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.contains
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentResettingCodeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ResettingCodeFragment : Fragment() {

    private val bindingResettingCode by lazy {
        FragmentResettingCodeBinding.inflate(layoutInflater)
    }
    private var checkerEmail = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingResettingCode.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingResettingCode.editEmailResetContainer.editText?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                when {
                    bindingResettingCode.editEmailReset.text?.isEmpty() == true ->
                        bindingResettingCode.editEmailResetContainer.error =
                            resources.getString(R.string.error_message_input_email_1)

                    !bindingResettingCode.editEmailReset.text?.contains('@')!! ->
                        bindingResettingCode.editEmailReset.error =
                            resources.getString(R.string.error_message_input_email)
                    else -> {
                        bindingResettingCode.editEmailResetContainer.error = null
                        checkerEmail = true
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        bindingResettingCode.btnEmailReset.setOnClickListener {
            when {
                checkerEmail -> bindingResettingCode.btnEmailReset.setOnClickListener {
                    findNavController().navigate(R.id.action_authorizationEmailFragment_to_authorizationEnterPinFragment)
                }
                else -> bindingResettingCode.editEmailResetContainer.error =
                    resources.getString(R.string.error_message_input_email_1)
            }
        }

        bindingResettingCode.btnEmailReset.setOnClickListener {
            MaterialAlertDialogBuilder(
                requireContext(),
                R.style.ResetTheme
            )

                .setMessage("Мы отправили вам письмо  с ссылкой для сброса кода")
                .setIcon(R.mipmap.ic_launcher)
                .setNeutralButton("Продолжить") { _, _ ->
                    findNavController().navigate(R.id.action_resettingCodeFragment_to_authorizationEmailFragment)
                }
                .show()
        }
    }
}