package com.armenia_guide.ui.authorization

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.armenia_guide.view_models.AuthorizationPinViewModel
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationEnterPinBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AuthorizationEnterPinFragment : Fragment() {

    private val viewModel: AuthorizationPinViewModel by viewModel()
    private var pin1: String = ""
    private val bindingAuthorizationEnterPin by lazy {
        FragmentAuthorizationEnterPinBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingAuthorizationEnterPin.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingAuthorizationEnterPin.editTextEnterPin.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                pin1 = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                when (p0?.length) {
                    5 -> {
                        bindingAuthorizationEnterPin.circle5.setImageResource(R.drawable.circle_pin_view_black)
                        viewModel.sendPin(pin1)
                        findNavController().navigate(R.id.action_authorizationEnterPinFragment_to_authorizationRepeatPinFragment)
                    }
                    4 -> {
                        bindingAuthorizationEnterPin.circle5.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationEnterPin.circle4.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    3 -> {
                        bindingAuthorizationEnterPin.circle4.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationEnterPin.circle3.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    2 -> {
                        bindingAuthorizationEnterPin.circle3.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationEnterPin.circle2.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    1 -> {
                        bindingAuthorizationEnterPin.circle2.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationEnterPin.circle1.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    else -> bindingAuthorizationEnterPin.circle1.setImageResource(R.drawable.circle_pin_view_grey)
                }
            }
        })
    }
}