package com.armenia_guide.ui.auth_client

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentConfirmEmailBinding

class ConfirmEmailFragment : Fragment() {
    private val showBindingConfirmEmail by lazy { FragmentConfirmEmailBinding.inflate(layoutInflater) }
    lateinit var inputEmailEditText: EditText
    private var errorEmailInputMessage = resources.getString(R.string.error_message_input_email)
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

        inputEmailEditText = showBindingConfirmEmail.editInputEmail

        inputEmailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (inputEmailEditText.text.contains("@")) {
                    showBindingConfirmEmail.textInputEmail.error = null
                    showBindingConfirmEmail.btnStart.isActivated = true
                    showBindingConfirmEmail.btnStart.background =
                        resources.getDrawable(R.drawable.background_button_red, null)
                } else {
                    showBindingConfirmEmail.textInputEmail.error = errorEmailInputMessage
                    showBindingConfirmEmail.btnStart.isActivated = false
                    showBindingConfirmEmail.btnStart.background =
                        resources.getDrawable(R.drawable.background_button_gray, null)
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        showBindingConfirmEmail.btnStart.setOnClickListener {
            if (showBindingConfirmEmail.btnStart.isActivated) {
                findNavController().navigate(R.id.action_confirmEmailFragment_to_checkEmailFragment)
            }
        }
    }


}