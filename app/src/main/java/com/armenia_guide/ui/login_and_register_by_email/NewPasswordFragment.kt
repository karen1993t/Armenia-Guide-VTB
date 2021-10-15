package com.armenia_guide.ui.login_and_register_by_email

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentNewPasswordBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.view_models.RegisterAndLoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewPasswordFragment :Fragment() {
    private val newPasswordBinding by lazy { FragmentNewPasswordBinding.inflate(layoutInflater) }
    private val sharedViewModel:RegisterAndLoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return newPasswordBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBackPressed()

        newPasswordBinding.btnResetPassword.setOnClickListener{

            sharedViewModel.setPositionFragment(ConstantsTools.LOGIN_USER_POSITION)
            findNavController().navigate(R.id.action_newPasswordFragment_to_loginViaEmailFragment)
        }
    }

    private fun onBackPressed(){
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            sharedViewModel.setPositionFragment(ConstantsTools.LOGIN_USER_POSITION)
            findNavController().popBackStack()


        }
    }
}