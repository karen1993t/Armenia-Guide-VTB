package com.armenia_guide.ui.biometry_access

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.Spanned
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import android.text.method.KeyListener
import android.text.method.TextKeyListener
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPersonalInformationBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.tools.CustomDateDialogTools
import com.armenia_guide.view_models.AuthorizationAndBiometryViewModel


class PersonalInformationFragment : Fragment() {
    private var showBindingPersonalInformation: FragmentPersonalInformationBinding? = null
    private lateinit var arrayAdapterGender: ArrayAdapter<String>
    private lateinit var arrayAdapterCitizenShip: ArrayAdapter<String>
    private val sharedViewModel: AuthorizationAndBiometryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingPersonalInformation =
            FragmentPersonalInformationBinding.inflate(inflater, container, false)
        return showBindingPersonalInformation?.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val genderList = resources.getStringArray(R.array.gender)
        val citizenShipList = resources.getStringArray(R.array.citizen_ship)



        arrayAdapterGender =
            ArrayAdapter(
                requireContext(),
                R.layout.drop_down_item_gender,
                R.id.text_view_drop_down,
                genderList
            )

        arrayAdapterCitizenShip = ArrayAdapter(
            requireContext(),
            R.layout.drop_down_item_search,
            R.id.text_view_drop_down,
            citizenShipList
        )
        showBindingPersonalInformation?.editUserGender?.setAdapter(arrayAdapterGender)
        showBindingPersonalInformation?.searchEditUserCitizenShip?.setAdapter(
            arrayAdapterCitizenShip
        )
        isCheckedInputTexts()

        showBindingPersonalInformation?.editUserDateOfBirth?.setOnClickListener {
            showBindingPersonalInformation?.editUserDateOfBirth?.let {
                CustomDateDialogTools.createDateDialog(
                    requireContext(),
                    ConstantsTools.FORMAT_DATE,
                    it
                )
            }

        }

        showBindingPersonalInformation?.editUserGender?.setOnClickListener {
            showBindingPersonalInformation?.editUserGender?.showDropDown()
        }

        showBindingPersonalInformation?.editUserCitizenShip?.setOnClickListener {
            showBindingPersonalInformation?.containerPersonalInformation?.background =
                resources.getDrawable(R.color.gray, null)

            showBindingPersonalInformation?.containerSearchCitizenShip?.visibility = View.VISIBLE

        }
        showBindingPersonalInformation?.searchEditUserCitizenShip?.setOnDismissListener {
            showBindingPersonalInformation?.containerPersonalInformation?.background =
                resources.getDrawable(R.color.white, null)

            showBindingPersonalInformation?.containerSearchCitizenShip?.visibility = View.GONE
            showBindingPersonalInformation?.editUserCitizenShip?.text =
                showBindingPersonalInformation?.searchEditUserCitizenShip?.text
        }
        showBindingPersonalInformation?.btnNext?.setOnClickListener {
            isCheckedInputTextsAndNext()

        }

        showBindingPersonalInformation?.btnClose?.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_personalInformationFragment_to_biometryAccessFragment)
        }
    }

    private fun isCheckedInputTextsAndNext() {
        val errorText = resources.getString(R.string.text_error_input_edit_text)
        when {

            showBindingPersonalInformation?.editUserFirstName?.text.toString()
                .isEmpty() -> {
                showBindingPersonalInformation?.textInputLayoutFirstName?.isErrorEnabled = true
                showBindingPersonalInformation?.textInputLayoutFirstName?.error =
                    errorText
            }
            showBindingPersonalInformation?.editUserSurname?.text.toString().isEmpty() -> {
                showBindingPersonalInformation?.textInputLayoutSurname?.isErrorEnabled = true
                showBindingPersonalInformation?.textInputLayoutSurname?.error = errorText
            }
            showBindingPersonalInformation?.editUserDateOfBirth?.text.toString().isEmpty() -> {
                showBindingPersonalInformation?.textInputLayoutDateOfBirth?.isErrorEnabled =
                    true
                showBindingPersonalInformation?.textInputLayoutDateOfBirth?.error = errorText
            }
            showBindingPersonalInformation?.editUserGender?.text.toString().isEmpty() -> {
                showBindingPersonalInformation?.textInputLayoutGender?.isErrorEnabled =
                    true
                showBindingPersonalInformation?.textInputLayoutGender?.error = errorText
            }
            showBindingPersonalInformation?.editUserCitizenShip?.text.toString().isEmpty() -> {
                showBindingPersonalInformation?.textInputLayoutCitizenShip?.isErrorEnabled =
                    true
                showBindingPersonalInformation?.textInputLayoutCitizenShip?.error = errorText
            }
            else -> showBindingPersonalInformation?.root?.let { view ->
                sendData()
                Navigation.findNavController(view)
                    .navigate(R.id.action_personalInformationFragment_to_phoneNumberFragment)
            }
        }
    }

    private fun isCheckedInputTexts() {
        showBindingPersonalInformation?.editUserFirstName?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                when {
                    showBindingPersonalInformation?.editUserFirstName?.text.toString()
                        .isNotEmpty() -> showBindingPersonalInformation?.textInputLayoutFirstName?.isErrorEnabled =
                        false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        showBindingPersonalInformation?.editUserSurname?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                when {
                    showBindingPersonalInformation?.editUserSurname?.text.toString()
                        .isNotEmpty() -> showBindingPersonalInformation?.textInputLayoutSurname?.isErrorEnabled =
                        false
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        showBindingPersonalInformation?.editUserDateOfBirth?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                when {
                    showBindingPersonalInformation?.editUserDateOfBirth?.text.toString()
                        .isNotEmpty() -> showBindingPersonalInformation?.textInputLayoutDateOfBirth?.isErrorEnabled =
                        false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        showBindingPersonalInformation?.editUserGender?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                when {
                    showBindingPersonalInformation?.editUserGender?.text.toString()
                        .isNotEmpty() -> showBindingPersonalInformation?.textInputLayoutGender?.isErrorEnabled =
                        false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        showBindingPersonalInformation?.editUserCitizenShip?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                when {
                    showBindingPersonalInformation?.editUserCitizenShip?.text.toString()
                        .isNotEmpty() -> showBindingPersonalInformation?.textInputLayoutCitizenShip?.isErrorEnabled =
                        false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun sendData() {
        sharedViewModel.setFirstName(showBindingPersonalInformation?.editUserFirstName?.text.toString())
        sharedViewModel.setSurName(showBindingPersonalInformation?.editUserSurname?.text.toString())
        sharedViewModel.setDateOfBirth(showBindingPersonalInformation?.editUserDateOfBirth?.text.toString())
        sharedViewModel.setGender(showBindingPersonalInformation?.editUserGender?.text.toString())
        sharedViewModel.setCitizenShip(showBindingPersonalInformation?.editUserCitizenShip?.text.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showBindingPersonalInformation = null
    }
}