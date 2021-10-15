package com.armenia_guide.ui.login_and_register_by_email

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentDialogSendMessageResetPasswordBinding
import com.armenia_guide.databinding.FragmentResetPasswordBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.tools.KeyboardTools
import com.armenia_guide.view_models.RegisterAndLoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResetPasswordFragment : Fragment() {
    private val resetPasswordBinding by lazy { FragmentResetPasswordBinding.inflate(layoutInflater) }
    private val sharedViewModel: RegisterAndLoginViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return resetPasswordBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resetPasswordBinding.editInputEmail.requestFocus()
        KeyboardTools.showKeyboard(requireContext())


        resetPasswordBinding.btnResetPassword.setOnClickListener {
            createSendingMessageDialog()
        }


    }


    private fun createSendingMessageDialog() {
        val myDialogFragment = AlertDialog.Builder(requireContext())
        val messageDialogBinding by lazy {
            FragmentDialogSendMessageResetPasswordBinding.inflate(
                layoutInflater
            )
        }
        myDialogFragment.setView(messageDialogBinding.root)
        val dialog = myDialogFragment.create()
        dialog.show()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))



        messageDialogBinding.textBtnToHomeDialog.setOnClickListener {
            sharedViewModel.setPositionFragment(ConstantsTools.NEW_PASSWORD_POSITION)
            dialog.dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        KeyboardTools.hideKeyboard()
    }
}