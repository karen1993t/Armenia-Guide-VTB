package com.armenia_guide.ui.personal_area

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentResettingCodeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class ResettingCodeFragment : Fragment() {
private var bindingResettingCodeFragment:FragmentResettingCodeBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingResettingCodeFragment= FragmentResettingCodeBinding.inflate(inflater)
        return bindingResettingCodeFragment?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingResettingCodeFragment?.btnEmailReset?.setOnClickListener {

            MaterialAlertDialogBuilder(
                requireContext(),
                R.style.ResetTheme
            )

                .setIcon(R.drawable.ic_send_email)
                .setMessage("Мы отправили вам письмо  с ссылкой для сброса кода")
                .setNeutralButton("Продолжить") { _, _ ->
//                    Navigation.findNavController(view)
//                        .navigate(R.id.action_authorizationPersonalAreaFragment_to_resettingCodeFragment)
                }


                .show()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingResettingCodeFragment=null
    }

}