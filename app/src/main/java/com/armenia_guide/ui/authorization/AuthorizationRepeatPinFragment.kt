package com.armenia_guide.ui.authorization

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.armenia_guide.view_models.AuthorizationPinViewModel
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationRepeatPinBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AuthorizationRepeatPinFragment : Fragment() {

    private val bindingAuthorizationRepeatPin by lazy {
        FragmentAuthorizationRepeatPinBinding.inflate(layoutInflater)
    }
    private val viewModel: AuthorizationPinViewModel by viewModel()
    private var pin1: String = ""
    private var pin2: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingAuthorizationRepeatPin.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPinLiveData.observe(viewLifecycleOwner, {
            pin1 = it
        })

        bindingAuthorizationRepeatPin.editTextEnterPin.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                pin2 = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                when (p0?.length) {
                    5 -> {
                        if (pin1 != pin2) {
                            bindingAuthorizationRepeatPin.circle5.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPin.circle4.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPin.circle3.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPin.circle2.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPin.circle1.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPin.circlePin5.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPin.circlePin4.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPin.circlePin3.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPin.circlePin2.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPin.circlePin1.setImageResource(R.drawable.circle_pin_view_red)
                        } else {
                            bindingAuthorizationRepeatPin.circle5.setImageResource(R.drawable.circle_pin_view_black)
                            viewModel.sendPin2(pin2)
                           findNavController().navigate(R.id.action_authorizationRepeatPinFragment_to_authorizationPersonalAreaFragment)
                        }
                    }

                    4 -> {
                        bindingAuthorizationRepeatPin.circle5.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationRepeatPin.circle4.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPin.circle3.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPin.circle2.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPin.circle1.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPin.circlePin5.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPin.circlePin4.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPin.circlePin3.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPin.circlePin2.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPin.circlePin1.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    3 -> {
                        bindingAuthorizationRepeatPin.circle4.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationRepeatPin.circle3.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    2 -> {
                        bindingAuthorizationRepeatPin.circle3.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationRepeatPin.circle2.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    1 -> {
                        bindingAuthorizationRepeatPin.circle2.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationRepeatPin.circle1.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    else -> bindingAuthorizationRepeatPin.circle1.setImageResource(R.drawable.circle_pin_view_grey)
                }
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback() {
            findNavController().navigate(R.id.action_authorizationRepeatPinFragment_to_authorizationEmailFragment)
        }
    }
}

