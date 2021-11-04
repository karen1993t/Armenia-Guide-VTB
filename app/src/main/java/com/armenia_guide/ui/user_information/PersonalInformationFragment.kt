package com.armenia_guide.ui.user_information

import android.annotation.SuppressLint
import android.graphics.Color.BLACK
import android.graphics.Color.WHITE
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPersonalInformationBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.tools.ConstantsTools.ERROR_EDIT_TEXT
import com.armenia_guide.tools.ConstantsTools.PERSONAL_INFORMATION_POSITION
import com.armenia_guide.tools.CustomDateDialogTools
import com.armenia_guide.tools.TabLayoutUserInformation
import com.armenia_guide.view_models.AuthorizationUserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonalInformationFragment : Fragment() {

    private lateinit var bindingPersonalInformation: FragmentPersonalInformationBinding

    private lateinit var citizenShip: String
    private lateinit var name: String
    private lateinit var lastName: String
    private lateinit var dataBirth: String
    private var gender: String = ""
    private var checkerName = false
    private var checkerLastName = false
    private var checkerBirthData = false
    private var checkerCitizenShip = false
    private lateinit var arrayAdapterGender: ArrayAdapter<String>
    private val sharedViewModel: AuthorizationUserViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bindingPersonalInformation = FragmentPersonalInformationBinding.inflate(layoutInflater)

        TabLayoutUserInformation.tabLayoutFragments(bindingPersonalInformation.tabLayoutUserInformation)

        checkerGender()

        return bindingPersonalInformation.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingPersonalInformation.tabLayoutUserInformation.getTabAt(PERSONAL_INFORMATION_POSITION)
            ?.select()

        bindingPersonalInformation.btnClose.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }


        dataBirth()
        citizenShip()
        isCheckedInputTexts()
        checkerAndClick()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkerAndClick() {

        bindingPersonalInformation.btnNext.setOnClickListener {
            when {
                checkerName && checkerLastName && checkerBirthData && checkerCitizenShip -> {

                    sendData()
                    findNavController()
                        .navigate(R.id.action_personalInformationFragment_to_phoneNumberFragment)
                }
                !checkerName -> {
                    bindingPersonalInformation.textInputLayoutFirstName.error =
                        ERROR_EDIT_TEXT
                }
                !checkerLastName -> {
                    bindingPersonalInformation.textInputLayoutLastName.error =
                        ERROR_EDIT_TEXT
                }
                !checkerBirthData -> {
                    bindingPersonalInformation.textInputLayoutDateOfBirth.error =
                        ERROR_EDIT_TEXT
                }
                !checkerCitizenShip -> {
                    bindingPersonalInformation.textInputLayoutCitizenShip.error =
                        ERROR_EDIT_TEXT
                }
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkerIsEmpty() {
        if (checkerName && checkerLastName && checkerBirthData && checkerCitizenShip) {
            bindingPersonalInformation.btnNext.background =
                resources.getDrawable(R.drawable.background_button_red, null)
        }
        else{
            bindingPersonalInformation.btnNext.background =
                resources.getDrawable(R.drawable.background_button_gray, null)
        }
    }

    private fun citizenShip() {
        val getCitizenShip = resources.getStringArray(R.array.countries)
        arrayAdapterGender =
            ArrayAdapter(requireContext(), R.layout.drop_down_item_country, getCitizenShip)
        bindingPersonalInformation.editCitizenShip.setAdapter(arrayAdapterGender)

        bindingPersonalInformation.editCitizenShip.setOnClickListener {
            bindingPersonalInformation.editCitizenShip.showDropDown()
        }

        bindingPersonalInformation.editCitizenShip.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                citizenShip = p0.toString()
                if (!bindingPersonalInformation.editCitizenShip.text.isNullOrEmpty()) {
                    bindingPersonalInformation.textInputLayoutCitizenShip.isErrorEnabled = false
                    bindingPersonalInformation.textInputLayoutCitizenShip.error = null
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun isCheckedInputTexts() {

        bindingPersonalInformation.editUserFirstName.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                name = p0.toString()
                when {
                    bindingPersonalInformation.editUserFirstName.text.isNullOrEmpty() -> {
                        bindingPersonalInformation.textInputLayoutFirstName.error =  ERROR_EDIT_TEXT
                    }
                    else -> {
                        bindingPersonalInformation.textInputLayoutFirstName.error = null
                        checkerName = true
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                checkerIsEmpty()
            }
        })

        bindingPersonalInformation.editUserLastName.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lastName = p0.toString()
                when {
                    bindingPersonalInformation.editUserLastName.text.isNullOrEmpty() -> {
                        bindingPersonalInformation.textInputLayoutLastName.error =  ERROR_EDIT_TEXT
                    }
                    else -> {
                        bindingPersonalInformation.textInputLayoutLastName.error = null
                        checkerLastName = true
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                checkerIsEmpty()
            }
        })

        bindingPersonalInformation.editUserDateOfBirth.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                dataBirth = p0.toString()
                when {
                    bindingPersonalInformation.editUserDateOfBirth.text.isNullOrEmpty() -> {
                        bindingPersonalInformation.textInputLayoutDateOfBirth.error =  ERROR_EDIT_TEXT
                    }
                    else -> {
                        bindingPersonalInformation.textInputLayoutDateOfBirth.error = null
                        checkerBirthData = true
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                checkerIsEmpty()
            }
        })

        bindingPersonalInformation.editCitizenShip.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                citizenShip = p0.toString()
                when {
                    bindingPersonalInformation.editCitizenShip.text.isNullOrEmpty() -> {
                        bindingPersonalInformation.textInputLayoutCitizenShip.error =  ERROR_EDIT_TEXT
                    }
                    else -> {
                        bindingPersonalInformation.textInputLayoutCitizenShip.error = null
                        checkerCitizenShip = true
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                checkerIsEmpty()
            }
        })
    }

    private fun sendData() {
        sharedViewModel.setFirstName(name)
        sharedViewModel.setSurName(lastName)
        sharedViewModel.setDateOfBirth(dataBirth)
        sharedViewModel.setCitizenShip(citizenShip)
        sharedViewModel.setGender(gender)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkerGender() {
        bindingPersonalInformation.btnMale.setOnCheckedChangeListener { compoundButton: CompoundButton, _: Boolean ->
            if (compoundButton.isChecked) {
                bindingPersonalInformation.btnMale.background =
                    resources.getDrawable(R.drawable.background_button_red, null)
                bindingPersonalInformation.btnMale.setTextColor(WHITE)
                gender = bindingPersonalInformation.btnMale.text.toString()
            } else {
                bindingPersonalInformation.btnMale.background =
                    resources.getDrawable(R.drawable.background_button_white, null)
                bindingPersonalInformation.btnMale.setTextColor(BLACK)
            }
        }

        bindingPersonalInformation.btnFemale.setOnCheckedChangeListener { compoundButton: CompoundButton, _: Boolean ->
            if (compoundButton.isChecked) {
                bindingPersonalInformation.btnFemale.background =
                    resources.getDrawable(R.drawable.background_button_red, null)
                bindingPersonalInformation.btnFemale.setTextColor(WHITE)
                gender = bindingPersonalInformation.btnFemale.text.toString()
            } else {
                bindingPersonalInformation.btnFemale.background =
                    resources.getDrawable(R.drawable.background_button_white, null)
                bindingPersonalInformation.btnFemale.setTextColor(BLACK)
            }
        }
    }

    private fun dataBirth() {
        bindingPersonalInformation.editUserDateOfBirth.setOnClickListener {
            bindingPersonalInformation.editUserDateOfBirth.also {
                CustomDateDialogTools.createDateDialog(
                    requireContext(),
                    ConstantsTools.FORMAT_DATE,
                    it
                )
            }
        }
    }
}