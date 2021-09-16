package com.armenia_guide.personal_area

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.armenia_guide.CustomViewModel
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationPersonalAreaBinding

class AuthorizationPersonalAreaFragment : Fragment() {

    private var bindingAuthorizationPersonalAreaBinding: FragmentAuthorizationPersonalAreaBinding? =
        null
    private val viewModel: CustomViewModel by activityViewModels()
    private var pinPersonalArea: String = ""
    private var pin2: String = ""



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingAuthorizationPersonalAreaBinding =
            FragmentAuthorizationPersonalAreaBinding.inflate(inflater)

        return bindingAuthorizationPersonalAreaBinding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPin2LiveData.observe(viewLifecycleOwner, {
            pin2 = it
            Log.d("pin7", "pin2 = $it")
        })


        bindingAuthorizationPersonalAreaBinding?.editTextPersonalArea?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                pinPersonalArea = p0.toString()
                Log.d("pin7", "pin = $pinPersonalArea")
            }

            override fun afterTextChanged(p0: Editable?) {
                when (p0?.length) {
                    5 -> {
                        if (pinPersonalArea != pin2) {
                            bindingAuthorizationPersonalAreaBinding?.circle5?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalAreaBinding?.circle4?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalAreaBinding?.circle3?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalAreaBinding?.circle2?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalAreaBinding?.circle1?.setImageResource(R.drawable.circle_pin_view_red)

                        } else {
                            bindingAuthorizationPersonalAreaBinding?.circle5?.setImageResource(R.drawable.circle_pin_view_black)
                            //  Navigation.findNavController(view).navigate(R.id.action_authorizationRepeatPinFragment_to_authorizationPersonalAreaFragment)
                        }
                    }

                    4 -> {
                        bindingAuthorizationPersonalAreaBinding?.circle5?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationPersonalAreaBinding?.circle4?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationPersonalAreaBinding?.circle3?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationPersonalAreaBinding?.circle2?.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationPersonalAreaBinding?.circle1?.setImageResource(R.drawable.circle_pin_view_black)

                    }
                    3 -> {
                        bindingAuthorizationPersonalAreaBinding?.circle4?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationPersonalAreaBinding?.circle3?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    2 -> {
                        bindingAuthorizationPersonalAreaBinding?.circle3?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationPersonalAreaBinding?.circle2?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    1 -> {
                        bindingAuthorizationPersonalAreaBinding?.circle2?.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationPersonalAreaBinding?.circle1?.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    else -> bindingAuthorizationPersonalAreaBinding?.circle1?.setImageResource(R.drawable.circle_pin_view_grey)
                }
            }
        })


    }

    override fun onResume() {
        if (bindingAuthorizationPersonalAreaBinding?.editTextPersonalArea?.requestFocus() == true) {
            activity?.window?.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
            ); }
        super.onResume()
    }
}