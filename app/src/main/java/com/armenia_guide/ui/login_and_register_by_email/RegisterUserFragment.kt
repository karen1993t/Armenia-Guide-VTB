package com.armenia_guide.ui.login_and_register_by_email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentRegisterUserBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.tools.RefactorTextColorsTools
import com.armenia_guide.view_models.RegisterAndLoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterUserFragment : Fragment() {
    private val registerUserBinding by lazy { FragmentRegisterUserBinding.inflate(layoutInflater) }
    private val sharedViewModel: RegisterAndLoginViewModel by viewModel()

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

        registerUserBinding.btnRegisterUser.setOnClickListener {
            sharedViewModel.setPositionFragment(ConstantsTools.EMAIL_CONFIRM_POSITION)

        }

    }
}