package com.armenia_guide.ui.login_and_register_by_email

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentLoginViaEmailBinding


class LoginViaEmailFragment : Fragment(), View.OnClickListener {

    private val loginViaEmailBinding by lazy { FragmentLoginViaEmailBinding.inflate(layoutInflater) }
    private val registerFragment = RegisterUserFragment()
    private val loginFragment = LoginUserFragment()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return loginViaEmailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null)
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_login_or_register, registerFragment)
                .commit()

        loginViaEmailBinding.btnLogin.setOnClickListener(this)
        loginViaEmailBinding.btnRegister.setOnClickListener(this)
        loginViaEmailBinding.btnClose.setOnClickListener(this)


    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onClick(view: View?) {
        val btnRegister = loginViaEmailBinding.btnRegister
        val btnLogin = loginViaEmailBinding.btnLogin
        val btnBack = loginViaEmailBinding.btnClose

        val stateTextColorPressedLoginBtn = resources.getColor(R.color.white, null)
        val stateTextColorPressedRegisterBtn = resources.getColor(R.color.white, null)
        val stateTexColorDefaultBtn = resources.getColor(R.color.black, null)

        when (view?.id) {
            btnRegister.id -> {
                btnRegister.apply {
                    background =
                        resources.getDrawable(R.drawable.background_button_red, null)
                    setTextColor(stateTextColorPressedRegisterBtn)
                }
                btnLogin.apply {
                    background =
                        resources.getDrawable(R.drawable.background_button_white, null)
                    setTextColor(stateTexColorDefaultBtn)
                }

                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.container_login_or_register, registerFragment)
                    .commit()
            }
            btnLogin.id -> {
                btnLogin.apply {
                    background =
                        resources.getDrawable(R.drawable.background_button_red, null)
                    setTextColor(stateTextColorPressedLoginBtn)
                }
                btnRegister.apply {
                    background =
                        resources.getDrawable(R.drawable.background_button_white, null)
                    setTextColor(stateTexColorDefaultBtn)
                }
                parentFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.container_login_or_register, loginFragment)
                    .commit()
            }
            btnBack.id -> findNavController().navigate(R.id.action_loginViaEmailFragment_to_profileFragment)
        }
    }
}