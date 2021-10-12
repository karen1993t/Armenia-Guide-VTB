package com.armenia_guide.ui.login_and_register_by_email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentLoginUserBinding

class LoginUserFragment : Fragment(), View.OnClickListener {
    private val loginUserBinding by lazy { FragmentLoginUserBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return loginUserBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginUserBinding.btnLoginUser.setOnClickListener(this)
        loginUserBinding.textResetPassword.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            loginUserBinding.btnLoginUser.id -> findNavController().navigate(R.id.action_loginViaEmailFragment_to_authorizationPersonalAreaFragment)
            loginUserBinding.textResetPassword.id ->
                findNavController().navigate(R.id.action_loginViaEmailFragment_to_resetPasswordFragment)

        }
    }
}