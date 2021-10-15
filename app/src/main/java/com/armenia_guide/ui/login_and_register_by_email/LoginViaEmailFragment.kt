package com.armenia_guide.ui.login_and_register_by_email

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentLoginViaEmailBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.view_models.RegisterAndLoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginViaEmailFragment : Fragment(), View.OnClickListener {

    private val loginViaEmailBinding by lazy { FragmentLoginViaEmailBinding.inflate(layoutInflater) }
    private val sharedViewModel: RegisterAndLoginViewModel by viewModel()

    private lateinit var btnRegister: Button
    private lateinit var btnLogin: Button
    private lateinit var btnBack: ImageView

    private lateinit var viewNav: FragmentContainerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return loginViaEmailBinding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewNav = loginViaEmailBinding.containerLoginOrRegister
        val statBackgroundButtonPressed =
            resources.getDrawable(R.drawable.background_button_red, null)
        val statBackgroundButtonDefault =
            resources.getDrawable(R.drawable.background_button_white, null)
        val stateTextColorPressedLoginBtn = resources.getColor(R.color.white, null)
        val stateTextColorPressedRegisterBtn = resources.getColor(R.color.white, null)
        val stateTexColorDefaultBtn = resources.getColor(R.color.black, null)



        btnRegister = loginViaEmailBinding.btnRegister
        btnLogin = loginViaEmailBinding.btnLogin
        btnBack = loginViaEmailBinding.btnClose

        loginViaEmailBinding.btnLogin.setOnClickListener(this)
        loginViaEmailBinding.btnRegister.setOnClickListener(this)
        loginViaEmailBinding.btnClose.setOnClickListener(this)
        Log.d("TAGS", "jjKK")


        onBackPressed()

        sharedViewModel.positionAuthorizationFragmentsLiveData.observe(viewLifecycleOwner,
            { position ->

                when (position) {
                    ConstantsTools.REGISTER_USER_POSITION -> {
                        btnRegister.setTextColor(stateTextColorPressedRegisterBtn)
                        btnRegister.background = statBackgroundButtonPressed
                        btnLogin.setTextColor(stateTexColorDefaultBtn)
                        btnLogin.background = statBackgroundButtonDefault
                        loginViaEmailBinding.titleLoginToEmail.text = "Вход через Email"

                        when (Navigation.findNavController(viewNav).currentDestination?.id) {

                            R.id.loginUserFragment -> Navigation.findNavController(viewNav)
                                .navigate(R.id.action_loginUserFragment_to_registerUserFragment)

                            R.id.resetPasswordFragment -> Navigation.findNavController(viewNav)
                                .navigate(R.id.action_resetPasswordFragment_to_registerUserFragment)
                        }


                    }
                    ConstantsTools.LOGIN_USER_POSITION -> {
                        btnLogin.setTextColor(stateTextColorPressedLoginBtn)
                        btnLogin.background = statBackgroundButtonPressed
                        btnRegister.setTextColor(stateTexColorDefaultBtn)
                        btnRegister.background = statBackgroundButtonDefault

                        loginViaEmailBinding.titleLoginToEmail.text = "Вход через Email"

                        when (Navigation.findNavController(viewNav).currentDestination?.id) {
                            R.id.registerUserFragment -> Navigation.findNavController(viewNav)
                                .navigate(R.id.action_registerUserFragment_to_loginUserFragment)

                            R.id.resetPasswordFragment -> Navigation.findNavController(viewNav)
                                .navigate(R.id.action_resetPasswordFragment_to_loginUserFragment)
                        }
                    }
                    ConstantsTools.RESET_PASSWORD_POSITION -> {
                        loginViaEmailBinding.titleLoginToEmail.text = "Сброс пароля"
                        if (Navigation.findNavController(viewNav).currentDestination?.id != R.id.resetPasswordFragment)
                            Navigation.findNavController(viewNav)
                                .navigate(R.id.action_loginUserFragment_to_resetPasswordFragment)
                    }
                    ConstantsTools.NEW_PASSWORD_POSITION ->
                        findNavController().navigate(R.id.action_loginViaEmailFragment_to_newPasswordFragment)
                    ConstantsTools.EMAIL_CONFIRM_POSITION ->
                        findNavController().navigate(R.id.action_loginViaEmailFragment_to_confirmEmailFragment)
                }
            })


    }


    override fun onClick(view: View?) {

        when (view?.id) {
            btnLogin.id -> {
                sharedViewModel.setPositionFragment(ConstantsTools.LOGIN_USER_POSITION)


            }
            btnRegister.id -> {
                sharedViewModel.setPositionFragment(ConstantsTools.REGISTER_USER_POSITION)

            }
        }


    }



    private fun onBackPressed() {

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().popBackStack()
            sharedViewModel.setPositionFragment(ConstantsTools.REGISTER_USER_POSITION)

        }
    }
}