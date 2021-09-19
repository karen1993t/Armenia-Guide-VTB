package com.armenia_guide.authorization

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationRepeatPinBinding

class AuthorizationRepeatPinFragment : Fragment() {
var bindingAuthorizationRepeatPinFragment:FragmentAuthorizationRepeatPinBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingAuthorizationRepeatPinFragment = FragmentAuthorizationRepeatPinBinding.inflate(inflater)
        bindingAuthorizationRepeatPinFragment?.editTextEnterPin?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


            }

            override fun afterTextChanged(p0: Editable?) {
                when (p0?.length) {
                    5-> bindingAuthorizationRepeatPinFragment?.circle5?.setImageResource(R.drawable.circle_pin_view_black)
                    4 -> {bindingAuthorizationRepeatPinFragment?.circle5?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationRepeatPinFragment?.circle4?.setImageResource(R.drawable.circle_pin_view_black)
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
        return bindingAuthorizationRepeatPinFragment?.root
    }

}