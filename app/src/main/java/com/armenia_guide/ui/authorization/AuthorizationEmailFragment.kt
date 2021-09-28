package com.armenia_guide.ui.authorization

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationEmailBinding

class AuthorizationEmailFragment : Fragment() {
    private val bindingAuthorizationEmailFragment by lazy {
        FragmentAuthorizationEmailBinding.inflate(layoutInflater)
    }
    private var checkerEmail = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingAuthorizationEmailFragment.editEmail.requestFocus()
        return bindingAuthorizationEmailFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingAuthorizationEmailFragment.editEmailContainer.editText?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                when {
                    bindingAuthorizationEmailFragment.editEmail.text?.isEmpty() == true ->
                        bindingAuthorizationEmailFragment.editEmailContainer.error =
                            resources.getString(R.string.error_message_input_email_1)

                    !bindingAuthorizationEmailFragment.editEmail.text?.contains('@')!! ->
                        bindingAuthorizationEmailFragment.editEmailContainer.error =
                            resources.getString(R.string.error_message_input_email)
                    else -> {
                        bindingAuthorizationEmailFragment.editEmailContainer.error = null
                        checkerEmail = true
                    }
                }
            }
        })

        bindingAuthorizationEmailFragment.btnNextEmail.setOnClickListener {
            when {
                checkerEmail -> bindingAuthorizationEmailFragment.btnNextEmail.setOnClickListener {
                    findNavController().navigate(R.id.action_authorizationEmailFragment_to_authorizationEnterPinFragment)
                }
                else -> bindingAuthorizationEmailFragment.editEmailContainer.error =
                    resources.getString(R.string.error_message_input_email_1)
            }
        }
    }
}