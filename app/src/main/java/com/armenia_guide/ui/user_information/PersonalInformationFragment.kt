package com.armenia_guide.ui.user_information

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color.BLACK
import android.graphics.Color.WHITE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R

import com.armenia_guide.databinding.FragmentPersonalInformationBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.tools.ConstantsTools.PERSONAL_INFORMATION_POSITION
import com.armenia_guide.tools.CustomDateDialogTools
import com.armenia_guide.tools.TabLayoutUserInformation
import com.armenia_guide.view_models.AuthorizationUserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonalInformationFragment : Fragment() {

    private lateinit var bindingPersonalInformation: FragmentPersonalInformationBinding

//    private val bindingBottomSheet: BottomSheetCitizenShipBinding by lazy {
//        BottomSheetCitizenShipBinding.inflate(
//            layoutInflater
//        )
//    }

    private lateinit var arrayAdapterGender: ArrayAdapter<String>
    private lateinit var arrayAdapterCitizenShip: ArrayAdapter<String>
    private val sharedViewModel: AuthorizationUserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bindingPersonalInformation = FragmentPersonalInformationBinding.inflate(layoutInflater)

        TabLayoutUserInformation.tabLayoutFragments(bindingPersonalInformation.tabLayoutUserInformation)

        return bindingPersonalInformation.root
    }

    @SuppressLint("ResourceAsColor", "ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingPersonalInformation.tabLayoutUserInformation.getTabAt(PERSONAL_INFORMATION_POSITION)
            ?.select()

//        bindingPersonalInformation.btnNext.setOnClickListener {
//            findNavController().navigate(R.id.action_personalInformationFragment_to_phoneNumberFragment)
//
//        }

        bindingPersonalInformation.btnClose.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }

        checkerGender()

        dataBirth()


        val showKeyboard: InputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        var selectedItemSearchCitizenShip: String

        bindingPersonalInformation.editCitizenShip.setOnClickListener {
            // Show bottom_sheet

            findNavController().navigate(R.id.action_personalInformationFragment_to_citizenShipFragment)
//            bottomSheetView.searchEditUserCitizenShip.requestFocus()
//
//            // show KeyBoard
//            showKeyboard.toggleSoftInput(InputMethodManager.RESULT_SHOWN, 0)
//
//            // Click item
//            bottomSheetView.searchEditUserCitizenShip.onItemClickListener =
//                AdapterView.OnItemClickListener { parent, _,
//                                                  position, _ ->
//                    selectedItemSearchCitizenShip = parent.getItemAtPosition(position).toString()
//                    bindingPersonalInformation.editCitizenShip.setText(
//                        selectedItemSearchCitizenShip
//                    )
//                    // close keyboard
//                    showKeyboard.toggleSoftInput(InputMethodManager.RESULT_HIDDEN, 0)
//
//                    bottomSheetCitizenShip.state = BottomSheetBehavior.STATE_COLLAPSED
        }


//
//        bindingBottomSheet.imgSearch.setOnClickListener {
//            bindingBottomSheet.imgSearch.isVisible = false
//            bindingBottomSheet.searchTextInputLayoutCitizenShip.isVisible = true
//            bindingBottomSheet.searchEditUserCitizenShip.requestFocus()
//
//        }
//        }
    }

//
//        isCheckedInputTexts()

//    private fun isCheckedInputTextsAndNext() {
//        val errorText = resources.getString(R.string.text_error_input_edit_text)
//        when {
//
//            bindingPersonalInformation.editUserFirstName.text.toString()
//                .isEmpty() -> {
//                bindingPersonalInformation.textInputLayoutFirstName.isErrorEnabled = true
//                bindingPersonalInformation.textInputLayoutFirstName.error =
//                    errorText
//            }
//            bindingPersonalInformation.editUserLastName.text.toString().isEmpty() -> {
//                bindingPersonalInformation.textInputLayoutLastName.isErrorEnabled = true
//                bindingPersonalInformation.textInputLayoutLastName.error = errorText
//            }
//            bindingPersonalInformation.editUserDateOfBirth.text.toString().isEmpty() -> {
//                bindingPersonalInformation.textInputLayoutDateOfBirth.isErrorEnabled =
//                    true
//                bindingPersonalInformation.textInputLayoutDateOfBirth.error = errorText
//            }

//            bindingPersonalInformation.editCitizenShip.text.toString().isEmpty() -> {
//                bindingPersonalInformation.textInputLayoutCitizenShip.isErrorEnabled =
//                    true
//                bindingPersonalInformation.textInputLayoutCitizenShip.error = errorText
//            }
//            else -> bindingPersonalInformation.root.let {
//                sendData()
//                findNavController()
//                    .navigate(R.id.action_personalInformationFragment_to_phoneNumberFragment)
//            }
//        }
//    }
//
//    private fun isCheckedInputTexts() {
//        showBindingPersonalInformation.editUserFirstName.addTextChangedListener(object :
//            TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                when {
//                    showBindingPersonalInformation.editUserFirstName.text.toString()
//                        .isNotEmpty() -> showBindingPersonalInformation.textInputLayoutFirstName.isErrorEnabled =
//                        false
//                }
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//        })
//        showBindingPersonalInformation.editUserSurname.addTextChangedListener(object :
//            TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                when {
//                    showBindingPersonalInformation.editUserSurname.text.toString()
//                        .isNotEmpty() -> showBindingPersonalInformation.textInputLayoutSurname.isErrorEnabled =
//                        false
//                }
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//
//            }
//
//        })
//        showBindingPersonalInformation.editUserDateOfBirth.addTextChangedListener(object :
//            TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                when {
//                    showBindingPersonalInformation.editUserDateOfBirth.text.toString()
//                        .isNotEmpty() -> showBindingPersonalInformation.textInputLayoutDateOfBirth.isErrorEnabled =
//                        false
//                }
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//        })
//        showBindingPersonalInformation.editUserGender.addTextChangedListener(object :
//            TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                when {
//                    showBindingPersonalInformation.editUserGender.text.toString()
//                        .isNotEmpty() -> showBindingPersonalInformation.textInputLayoutGender.isErrorEnabled =
//                        false
//                }
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//        })
//        showBindingPersonalInformation.editUserCitizenShip.addTextChangedListener(object :
//            TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//
//                when {
//                    showBindingPersonalInformation.editUserCitizenShip.text.toString()
//                        .isNotEmpty() -> showBindingPersonalInformation.textInputLayoutCitizenShip.isErrorEnabled =
//                        false
//                }
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//        })
//    }
//


    private fun sendData() {
        sharedViewModel.setFirstName(bindingPersonalInformation.editUserFirstName.text.toString())
        sharedViewModel.setSurName(bindingPersonalInformation.editUserLastName.text.toString())
        sharedViewModel.setDateOfBirth(bindingPersonalInformation.editUserDateOfBirth.text.toString())
        sharedViewModel.setCitizenShip(bindingPersonalInformation.editCitizenShip.text.toString())
        if (bindingPersonalInformation.btnMale.isChecked) {
            sharedViewModel.setGender(bindingPersonalInformation.btnMale.text.toString())
        } else {
            sharedViewModel.setGender(bindingPersonalInformation.btnFemale.text.toString())
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkerGender() {
        bindingPersonalInformation.btnMale.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            if (compoundButton.isChecked) {
                bindingPersonalInformation.btnMale.background =
                    resources.getDrawable(R.drawable.background_button_red, null)
                bindingPersonalInformation.btnMale.setTextColor(WHITE)

            } else {
                bindingPersonalInformation.btnMale.background =
                    resources.getDrawable(R.drawable.background_button_white, null)
                bindingPersonalInformation.btnMale.setTextColor(BLACK)
            }
        }

        bindingPersonalInformation.btnFemale.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            if (compoundButton.isChecked) {
                bindingPersonalInformation.btnFemale.background =
                    resources.getDrawable(R.drawable.background_button_red, null)
                bindingPersonalInformation.btnFemale.setTextColor(WHITE)

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