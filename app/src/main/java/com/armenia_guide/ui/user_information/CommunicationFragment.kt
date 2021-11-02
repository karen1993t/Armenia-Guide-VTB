package com.armenia_guide.ui.user_information

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentCommunicationBinding
import com.armenia_guide.tools.ConstantsTools.COMMUNICATION_WITH_THE_BANK
import com.armenia_guide.tools.TabLayoutUserInformation

class CommunicationFragment : Fragment() {

    private lateinit var bindingCommunication: FragmentCommunicationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bindingCommunication = FragmentCommunicationBinding.inflate(layoutInflater)

        TabLayoutUserInformation.tabLayoutFragments(bindingCommunication.tabLayoutUserInformation)

        return bindingCommunication.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingCommunication.tabLayoutUserInformation.getTabAt(COMMUNICATION_WITH_THE_BANK)
            ?.select()

        checkerEmail1()
        checkerEmail2()

        bindingCommunication.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_communicationFragment_to_dataInProcessingFragment)
        }

        bindingCommunication.btnClose.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkerEmail1() {

        bindingCommunication.btnEmail.setOnCheckedChangeListener { compoundButton: CompoundButton, _: Boolean ->
            if (compoundButton.isChecked) {
                bindingCommunication.btnEmail.background =
                    resources.getDrawable(R.drawable.background_button_red, null)
                bindingCommunication.btnEmail.setTextColor(Color.WHITE)

            } else {
                bindingCommunication.btnEmail.background =
                    resources.getDrawable(R.drawable.background_button_white, null)
                bindingCommunication.btnEmail.setTextColor(Color.BLACK)
            }
        }

        bindingCommunication.btnEmailRus.setOnCheckedChangeListener { compoundButton: CompoundButton, _: Boolean ->
            if (compoundButton.isChecked) {
                bindingCommunication.btnEmailRus.background =
                    resources.getDrawable(R.drawable.background_button_red, null)
                bindingCommunication.btnEmailRus.setTextColor(Color.WHITE)

            } else {
                bindingCommunication.btnEmailRus.background =
                    resources.getDrawable(R.drawable.background_button_white, null)
                bindingCommunication.btnEmailRus.setTextColor(Color.BLACK)
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkerEmail2() {

        bindingCommunication.btnEmail2.setOnCheckedChangeListener { compoundButton: CompoundButton, _: Boolean ->
            if (compoundButton.isChecked) {
                bindingCommunication.btnEmail2.background =
                    resources.getDrawable(R.drawable.background_button_red, null)
                bindingCommunication.btnEmail2.setTextColor(Color.WHITE)

            } else {
                bindingCommunication.btnEmail2.background =
                    resources.getDrawable(R.drawable.background_button_white, null)
                bindingCommunication.btnEmail2.setTextColor(Color.BLACK)
            }
        }

        bindingCommunication.btnEmailRus2.setOnCheckedChangeListener { compoundButton: CompoundButton, _: Boolean ->
            if (compoundButton.isChecked) {
                bindingCommunication.btnEmailRus2.background =
                    resources.getDrawable(R.drawable.background_button_red, null)
                bindingCommunication.btnEmailRus2.setTextColor(Color.WHITE)

            } else {
                bindingCommunication.btnEmailRus2.background =
                    resources.getDrawable(R.drawable.background_button_white, null)
                bindingCommunication.btnEmailRus2.setTextColor(Color.BLACK)
            }
        }

        bindingCommunication.btnSms.setOnCheckedChangeListener { compoundButton: CompoundButton, _: Boolean ->
            if (compoundButton.isChecked) {
                bindingCommunication.btnSms.background =
                    resources.getDrawable(R.drawable.background_button_red, null)
                bindingCommunication.btnSms.setTextColor(Color.WHITE)

            } else {
                bindingCommunication.btnSms.background =
                    resources.getDrawable(R.drawable.background_button_white, null)
                bindingCommunication.btnSms.setTextColor(Color.BLACK)
            }
        }
    }
}