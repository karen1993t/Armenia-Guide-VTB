package com.armenia_guide.personal_area

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.armenia_guide.CustomViewModel
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationPersonalAreaBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.concurrent.Executor

class AuthorizationPersonalAreaFragment : Fragment() {

    private var bindingAuthorizationPersonalAreaBinding: FragmentAuthorizationPersonalAreaBinding? =
        null
    private val viewModelPersonalArea: CustomViewModel by activityViewModels()
    private var pinPersonalArea: String = ""
    private var pin2: String = ""
    private var counter: Int = 0

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

        viewModelPersonalArea.getPin2LiveData.observe(viewLifecycleOwner, {
            pin2 = it
        })

        bindingAuthorizationPersonalAreaBinding?.editTextPersonalArea?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                pinPersonalArea = p0.toString()
            }
            override fun afterTextChanged(p0: Editable?) {
                when (p0?.length) {
                    5 -> {
                        if (pinPersonalArea != pin2) {
                            counter++
                            bindingAuthorizationPersonalAreaBinding?.circle5?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalAreaBinding?.circle4?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalAreaBinding?.circle3?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalAreaBinding?.circle2?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalAreaBinding?.circle1?.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalAreaBinding?.titleEnterPersonalArea1?.setTextColor(
                                resources.getColor(R.color.color_red, null)
                            )

                            when (counter) {
                                1 -> bindingAuthorizationPersonalAreaBinding?.titleEnterPersonalArea1?.text =
                                    getString(
                                        R.string.attempts_left_5
                                    )
                                2 -> bindingAuthorizationPersonalAreaBinding?.titleEnterPersonalArea1?.text =
                                    getString(
                                        R.string.attempts_left_4
                                    )
                                3 -> bindingAuthorizationPersonalAreaBinding?.titleEnterPersonalArea1?.text =
                                    getString(
                                        R.string.attempts_left_3
                                    )
                                4 -> bindingAuthorizationPersonalAreaBinding?.titleEnterPersonalArea1?.text =
                                    getString(
                                        R.string.attempts_left_2
                                    )
                                5 -> bindingAuthorizationPersonalAreaBinding?.titleEnterPersonalArea1?.text =
                                    getString(
                                        R.string.attempts_left_1
                                    )
                                else -> {
                                    bindingAuthorizationPersonalAreaBinding?.titleEnterPersonalArea1?.text =
                                        getString(
                                            R.string.attempts_left_0
                                        )
                                    MaterialAlertDialogBuilder(
                                        requireContext(),
                                        R.style.CutShapeTheme
                                    )
                                        .setTitle("Вход в личный кабинет ВТБ & Armenia Guide заблокирован")
                                        .setMessage("Сбросте код и повторите попитьку")
                                        .setNeutralButton("Сбросить") { _, _ ->
                                            Navigation.findNavController(view)
                                                .navigate(R.id.action_authorizationPersonalAreaFragment_to_resettingCodeFragment)
                                        }
                                        .show()
                                }
                            }

                        } else {
                            bindingAuthorizationPersonalAreaBinding?.circle5?.setImageResource(R.drawable.circle_pin_view_black)
                            Navigation.findNavController(view)
                                .navigate(R.id.action_authorizationPersonalAreaFragment_to_personalAreaFragment)
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

        val executor = ContextCompat.getMainExecutor(requireContext())
        val biometricManager = BiometricManager.from(requireContext())

        bindingAuthorizationPersonalAreaBinding?.titleEnterWithFaceId?.setOnClickListener {

            fun authUser(executor: Executor) {

                val promptInfo = BiometricPrompt.PromptInfo.Builder()

                    .setTitle("Authentication Required!")
                    .setSubtitle("Important authentication")
                    .setDescription("Please authenticate to be able to view your account information ")
                    .setDeviceCredentialAllowed(true)
                    .build()

                val biometricPrompt = BiometricPrompt(this, executor,
                    object : BiometricPrompt.AuthenticationCallback() {

                        override fun onAuthenticationSucceeded(
                            result: BiometricPrompt.AuthenticationResult
                        ) {
                            Navigation.findNavController(view)
                                .navigate(R.id.action_authorizationPersonalAreaFragment_to_personalAreaFragment)
                        }
                        
                        override fun onAuthenticationError(
                            errorCode: Int, errString: CharSequence
                        ) {
                            super.onAuthenticationError(errorCode, errString)
                            Toast.makeText(
                                requireContext(),
                                "Error Detect",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                biometricPrompt.authenticate(promptInfo)
            }

            when (biometricManager.canAuthenticate()) {
                BiometricManager.BIOMETRIC_SUCCESS ->
                    authUser(executor)
                BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                    Toast.makeText(
                        requireContext(),
                        "BIOMETRIC_ERROR_NO_HARDWARE",
                        Toast.LENGTH_LONG
                    ).show()
                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
                    Toast.makeText(
                        requireContext(),
                        "BIOMETRIC_ERROR_HW_UNAVAILABLE",
                        Toast.LENGTH_LONG
                    ).show()
                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED ->
                    Toast.makeText(
                        requireContext(),
                        "BIOMETRIC_ERROR_NONE_ENROLLED",
                        Toast.LENGTH_LONG
                    ).show()
            }
        }
    }

    override fun onResume() {
        if (bindingAuthorizationPersonalAreaBinding?.editTextPersonalArea?.requestFocus() == true) {
            activity?.window?.setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
            )
        }
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingAuthorizationPersonalAreaBinding = null
    }
}