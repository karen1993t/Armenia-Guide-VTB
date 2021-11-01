package com.armenia_guide.ui.user_information

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentCommunicationBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.view_models.PositionTabLayoutViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CommunicationFragment : Fragment() {
    private lateinit var bindingCommunication: FragmentCommunicationBinding
    private val getPositionTabLayoutViewModel: PositionTabLayoutViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingCommunication = FragmentCommunicationBinding.inflate(layoutInflater)
        return bindingCommunication.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       checkerEmail1()
       checkerEmail2()


        bindingCommunication.btnNext.setOnClickListener {
//            Navigation.findNavController(view)
//                .navigate(R.id.action_global_dataInProcessingFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        getPositionTabLayoutViewModel.sendPositionTabLayout(ConstantsTools.COMMUNICATION_WITH_THE_BANK)
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkerEmail1(){

        bindingCommunication.btnEmail.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
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

        bindingCommunication.btnEmailRus.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
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
    private fun checkerEmail2(){

        bindingCommunication.btnEmail2.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
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

        bindingCommunication.btnEmailRus2.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
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

        bindingCommunication.btnSms.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
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