package com.armenia_guide.ui.login_and_register_by_email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.armenia_guide.databinding.FragmentRegisterUserBinding
import com.armenia_guide.tools.RefactorTextColorsTools

class RegisterUserFragment : Fragment(), View.OnClickListener {
    private val registerUserBinding by lazy { FragmentRegisterUserBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return registerUserBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerUserBinding.textPrivacyPolicy.text =
            RefactorTextColorsTools.textPrivacyPolicy(requireContext())

        registerUserBinding.textPrivacyPolicy.setOnClickListener(this)
        registerUserBinding.btnRegisterUser.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when (view?.id) {
            registerUserBinding.btnRegisterUser.id -> Toast.makeText(
                requireContext(),
                "Register User",
                Toast.LENGTH_SHORT
            ).show()
            registerUserBinding.textPrivacyPolicy.id -> Toast.makeText(
                requireContext(),
                "Privacy Policy",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}