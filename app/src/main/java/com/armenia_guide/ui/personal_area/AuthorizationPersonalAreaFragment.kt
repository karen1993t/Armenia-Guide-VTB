package com.armenia_guide.ui.personal_area

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
import androidx.navigation.fragment.findNavController
import com.armenia_guide.view_models.AuthorizationPinViewModel
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationPersonalAreaBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.scope.fragmentScope
import java.util.concurrent.Executor

class AuthorizationPersonalAreaFragment : Fragment() {

    private val bindingAuthorizationPersonalArea by lazy {
      FragmentAuthorizationPersonalAreaBinding.inflate(layoutInflater)
    }
    private val viewModelPersonalArea: AuthorizationPinViewModel by activityViewModels()
    private var pinPersonalArea: String = ""
    private var pin2: String = ""
    private var counter: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        return bindingAuthorizationPersonalArea.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelPersonalArea.getPin2LiveData.observe(viewLifecycleOwner, {
            pin2 = it
        })

        bindingAuthorizationPersonalArea.editTextPersonalArea.addTextChangedListener(object :
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
                            bindingAuthorizationPersonalArea.circle5.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalArea.circle4.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalArea.circle3.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalArea.circle2.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalArea.circle1.setImageResource(R.drawable.circle_pin_view_red)
                            bindingAuthorizationPersonalArea.titleEnterPersonalArea1.setTextColor(
                                resources.getColor(R.color.color_red, null)
                            )

                            when (counter) {
                                1 -> bindingAuthorizationPersonalArea.titleEnterPersonalArea1.text =
                                    getString(
                                        R.string.attempts_left_5
                                    )
                                2 -> bindingAuthorizationPersonalArea.titleEnterPersonalArea1.text =
                                    getString(
                                        R.string.attempts_left_4
                                    )
                                3 -> bindingAuthorizationPersonalArea.titleEnterPersonalArea1.text =
                                    getString(
                                        R.string.attempts_left_3
                                    )
                                4 -> bindingAuthorizationPersonalArea.titleEnterPersonalArea1.text =
                                    getString(
                                        R.string.attempts_left_2
                                    )
                                5 -> bindingAuthorizationPersonalArea.titleEnterPersonalArea1.text =
                                    getString(
                                        R.string.attempts_left_1
                                    )
                                else -> {
                                    bindingAuthorizationPersonalArea.titleEnterPersonalArea1.text =
                                        getString(
                                            R.string.attempts_left_0
                                        )
                                    MaterialAlertDialogBuilder(
                                        requireContext(),
                                        R.style.CutShapeTheme
                                    )
                                        .setTitle(getString(R.string.enter_personal_area_blocked))
                                        .setMessage(getString(R.string.reset_pin_and_repeat))
                                        .setNeutralButton(getString(R.string.reset)) { _, _ ->
                                           findNavController().navigate(R.id.action_authorizationPersonalAreaFragment_to_resettingCodeFragment)
                                        }
                                        .show()
                                }
                            }

                        } else {
                            bindingAuthorizationPersonalArea.circle5.setImageResource(R.drawable.circle_pin_view_black)
                            findNavController().navigate(R.id.action_authorizationPersonalAreaFragment_to_bluePersonalAreaFragment)
                        }
                    }
                    4 -> {
                        bindingAuthorizationPersonalArea.circle5.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationPersonalArea.circle4.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationPersonalArea.circle3.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationPersonalArea.circle2.setImageResource(R.drawable.circle_pin_view_black)
                        bindingAuthorizationPersonalArea.circle1.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    3 -> {
                        bindingAuthorizationPersonalArea.circle4.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationPersonalArea.circle3.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    2 -> {
                        bindingAuthorizationPersonalArea.circle3.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationPersonalArea.circle2.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    1 -> {
                        bindingAuthorizationPersonalArea.circle2.setImageResource(R.drawable.circle_pin_view_grey)
                        bindingAuthorizationPersonalArea.circle1.setImageResource(R.drawable.circle_pin_view_black)
                    }
                    else -> bindingAuthorizationPersonalArea.circle1.setImageResource(R.drawable.circle_pin_view_grey)
                }
            }
        })

        val executor = ContextCompat.getMainExecutor(requireContext())
        val biometricManager = BiometricManager.from(requireContext())

        bindingAuthorizationPersonalArea.titleEnterWithFaceId.setOnClickListener {

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
                            findNavController().navigate(R.id.action_authorizationPersonalAreaFragment_to_personalAreaFragment)
                        }
                        
                        override fun onAuthenticationError(
                            errorCode: Int, errString: CharSequence
                        ) {
                            super.onAuthenticationError(errorCode, errString)
                            Toast.makeText(requireContext(),getString(R.string.error_detect),Toast.LENGTH_SHORT).show()
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
        super.onResume()
//        bindingAuthorizationPersonalArea.editTextPersonalArea.requestFocus()
//        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }

    override fun onPause() {
        bindingAuthorizationPersonalArea.editTextPersonalArea.isFocusable = false
        super.onPause()
    }
}