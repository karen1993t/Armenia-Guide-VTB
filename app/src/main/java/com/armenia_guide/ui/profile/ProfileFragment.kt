package com.armenia_guide.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentProfileBinding
import com.armenia_guide.tools.RefactorTextColorsTools


class ProfileFragment : Fragment(), View.OnClickListener {
    private val loginBinding by lazy { FragmentProfileBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBinding.textPrivacyPolicy.text =
            RefactorTextColorsTools.textPrivacyPolicy(requireContext())

        loginBinding.btnClose.setOnClickListener(this)
        loginBinding.btnLoginEmail.setOnClickListener(this)
        loginBinding.btnLoginApple.setOnClickListener(this)
        loginBinding.btnLoginFacebook.setOnClickListener(this)
        loginBinding.btnLoginVk.setOnClickListener(this)
        loginBinding.textPrivacyPolicy.setOnClickListener(this)
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            loginBinding.btnClose.id -> Toast.makeText(
                requireContext(),
                "Close page",
                Toast.LENGTH_SHORT
            ).show()
            loginBinding.btnLoginEmail.id -> findNavController().navigate(R.id.action_profileFragment_to_loginViaEmailFragment)
            loginBinding.btnLoginApple.id -> Toast.makeText(
                requireContext(),
                "Login Apple",
                Toast.LENGTH_SHORT
            ).show()
            loginBinding.btnLoginFacebook.id -> Toast.makeText(
                requireContext(),
                "Login Facebook",
                Toast.LENGTH_SHORT
            ).show()
            loginBinding.btnLoginVk.id -> Toast.makeText(
                requireContext(),
                "Login VK",
                Toast.LENGTH_SHORT
            ).show()

            loginBinding.textPrivacyPolicy.id -> Toast.makeText(
                requireContext(),
                "Policy Policy",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}