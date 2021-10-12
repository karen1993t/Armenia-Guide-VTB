package com.armenia_guide.ui.login_and_register_by_email

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentDialogSendMessageResetPasswordBinding
import com.armenia_guide.databinding.FragmentResetPasswordBinding

class ResetPasswordFragment : Fragment(), View.OnClickListener {
    private val resetPasswordBinding by lazy { FragmentResetPasswordBinding.inflate(layoutInflater) }


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
        resetPasswordBinding.btnBack.setOnClickListener(this)
        resetPasswordBinding.btnResetPassword.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            resetPasswordBinding.btnBack.id ->
                findNavController().navigate(R.id.action_resetPasswordFragment_to_loginViaEmailFragment)

            resetPasswordBinding.btnResetPassword.id ->
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
            findNavController().navigate(R.id.action_resetPasswordFragment_to_newPasswordFragment)
            dialog.dismiss()
        }
    }
}