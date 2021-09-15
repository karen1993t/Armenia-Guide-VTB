package com.armenia_guide.authorization

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationEnterPinBinding


class AuthorizationEnterPinFragment : Fragment() {
    var bindingAuthorizationEnterPinFragment: FragmentAuthorizationEnterPinBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingAuthorizationEnterPinFragment =
            FragmentAuthorizationEnterPinBinding.inflate(inflater)
        bindingAuthorizationEnterPinFragment?.editTextEnterPin?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                when (p0?.length) {
                    5 -> {
                        bindingAuthorizationEnterPinFragment?.circle5?.setImageResource(R.drawable.circle_pin_view_black)
                        view?.let {
                            Navigation.findNavController(it)
                                .navigate(R.id.action_authorizationEnterPinFragment_to_authorizationRepeatPinFragment)
                        }
                    }
                    4 -> {
                        bindingAuthorizationEnterPinFragment?.circle5?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationEnterPinFragment?.circle4?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    3 -> {
                        bindingAuthorizationEnterPinFragment?.circle4?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationEnterPinFragment?.circle3?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    2 -> {
                        bindingAuthorizationEnterPinFragment?.circle3?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationEnterPinFragment?.circle2?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    1 -> {
                        bindingAuthorizationEnterPinFragment?.circle2?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationEnterPinFragment?.circle1?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    else -> bindingAuthorizationEnterPinFragment?.circle1?.setImageResource(R.drawable.circle_pin_view_grey)
                }

            }

        })




        return bindingAuthorizationEnterPinFragment?.root
    }


}