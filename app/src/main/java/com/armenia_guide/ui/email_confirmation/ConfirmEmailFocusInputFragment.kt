package com.armenia_guide.ui.email_confirmation

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentConfirmEmailFocusInputBinding
import com.armenia_guide.databinding.FragmentDialogConfirmEmailBinding


class ConfirmEmailFocusInputFragment : Fragment() {

    private val confirmEmailInputBinding by lazy {
        FragmentConfirmEmailFocusInputBinding.inflate(
            layoutInflater
        )
    }
    private var titleDialogConfirm = ""
    private lateinit var editEmail: EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return confirmEmailInputBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editEmail = confirmEmailInputBinding.editInputEmail
        editEmail.requestFocus()


        confirmEmailInputBinding.btnConfirm.setOnClickListener {
            createSendingMessageDialog()
        }

    }


    private fun createSendingMessageDialog() {
        titleDialogConfirm =
            "На почту ${editEmail.text} выслана ссылка. Просим проверить почту\n" +
                    "и пройти по ней"
        val myDialogFragment = AlertDialog.Builder(requireContext())
        val messageDialogBinding by lazy {
            FragmentDialogConfirmEmailBinding.inflate(
                layoutInflater
            )
        }
        messageDialogBinding.titleSendMessageResetPassword.text = titleDialogConfirm
        myDialogFragment.setView(messageDialogBinding.root)
        val dialog = myDialogFragment.create()
        dialog.show()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        messageDialogBinding.textBtnToHomeDialog.setOnClickListener {
            findNavController().navigate(R.id.action_confirmEmailFocusInputFragment_to_questionnaireUserFragment)
            dialog.dismiss()
        }
    }
}