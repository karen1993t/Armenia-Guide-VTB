package com.armenia_guide.ui.login_and_register_by_email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentNewPasswordBinding

class NewPasswordFragment :Fragment() {
    private val newPasswordBinding by lazy { FragmentNewPasswordBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return newPasswordBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newPasswordBinding.btnResetPassword.setOnClickListener{
            findNavController().navigate(R.id.action_newPasswordFragment_to_loginViaEmailFragment)
        }
    }
}