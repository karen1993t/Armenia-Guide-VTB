package com.armenia_guide.ui.authorization

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.armenia_guide.view_models.AuthorizationPinViewModel
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationRepeatPinBinding


class AuthorizationRepeatPinFragment : Fragment() {

    private var bindingAuthorizationRepeatPinFragment: FragmentAuthorizationRepeatPinBinding? = null
    private val viewModel: AuthorizationPinViewModel by activityViewModels()
    private var pin1: String = ""
    private var pin2: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingAuthorizationRepeatPinFragment =
            FragmentAuthorizationRepeatPinBinding.inflate(inflater)

        return bindingAuthorizationRepeatPinFragment?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPinLiveData.observe(viewLifecycleOwner, {
            pin1 = it
        })

        bindingAuthorizationRepeatPinFragment?.editTextEnterPin?.addTextChangedListener(object :
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
                            bindingAuthorizationRepeatPinFragment?.circle5?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPinFragment?.circle4?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPinFragment?.circle3?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPinFragment?.circle2?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPinFragment?.circle1?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPinFragment?.circlePin5?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPinFragment?.circlePin4?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPinFragment?.circlePin3?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPinFragment?.circlePin2?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationRepeatPinFragment?.circlePin1?.setImageResource(R.drawable.circle_pin_view_red)
                        } else {
                            bindingAuthorizationRepeatPinFragment?.circle5?.setImageResource(R.drawable.circle_pin_view_black)
                            viewModel.sendPin2(pin2)
                            Navigation.findNavController(view).navigate(R.id.action_authorizationRepeatPinFragment_to_authorizationPersonalAreaFragment)



                        }
                    }

                    4 -> {
                        bindingAuthorizationRepeatPinFragment?.circle5?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationRepeatPinFragment?.circle4?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPinFragment?.circle3?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPinFragment?.circle2?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPinFragment?.circle1?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPinFragment?.circlePin5?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPinFragment?.circlePin4?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPinFragment?.circlePin3?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPinFragment?.circlePin2?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationRepeatPinFragment?.circlePin1?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    3 -> {
                        bindingAuthorizationRepeatPinFragment?.circle4?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationRepeatPinFragment?.circle3?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    2 -> {
                        bindingAuthorizationRepeatPinFragment?.circle3?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationRepeatPinFragment?.circle2?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    1 -> {
                        bindingAuthorizationRepeatPinFragment?.circle2?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationRepeatPinFragment?.circle1?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    else -> bindingAuthorizationRepeatPinFragment?.circle1?.setImageResource(R.drawable.circle_pin_view_grey)
                }
            }
        })
    }
    override fun onResume() {
        if (bindingAuthorizationRepeatPinFragment?.editTextEnterPin?.requestFocus() == true) { activity?.window?.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE); }
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingAuthorizationRepeatPinFragment = null
    }
}

