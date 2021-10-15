package com.armenia_guide.ui.login_and_register_by_email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.armenia_guide.databinding.FragmentLoginUserBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.tools.KeyboardTools
import com.armenia_guide.view_models.RegisterAndLoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginUserFragment : Fragment() {
    private val loginUserBinding by lazy { FragmentLoginUserBinding.inflate(layoutInflater) }
    private val sharedViewModel: RegisterAndLoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return loginUserBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginUserBinding.textResetPassword.setOnClickListener {
            sharedViewModel.setPositionFragment(ConstantsTools.RESET_PASSWORD_POSITION)
        }

    }

}