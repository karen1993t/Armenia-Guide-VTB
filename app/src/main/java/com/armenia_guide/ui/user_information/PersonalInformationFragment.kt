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
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.BottomSheetCitizenShipBinding
import com.armenia_guide.databinding.FragmentPersonalInformationBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.tools.ConstantsTools.PERSONAL_INFORMATION_POSITION
import com.armenia_guide.tools.CustomDateDialogTools
import com.armenia_guide.view_models.AuthorizationUserViewModel
import com.armenia_guide.view_models.PositionTabLayoutViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class PersonalInformationFragment : Fragment() {
    private lateinit var bindingPersonalInformation:FragmentPersonalInformationBinding

    private val bindingBottomSheet: BottomSheetCitizenShipBinding by lazy {
        BottomSheetCitizenShipBinding.inflate(
            layoutInflater
        )
    }
    private lateinit var arrayAdapterGender: ArrayAdapter<String>
    private lateinit var arrayAdapterCitizenShip: ArrayAdapter<String>
    private val sharedViewModel: AuthorizationUserViewModel by viewModel()
    private val getPositionTabLayoutViewModel: PositionTabLayoutViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingPersonalInformation = FragmentPersonalInformationBinding.inflate(layoutInflater)

        return bindingPersonalInformation.root
    }

    @SuppressLint("ResourceAsColor", "UseCompatLoadingForDrawables", "ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingPersonalInformation.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_personalInformationFragment_to_phoneNumberFragment)
        }

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

        //Date Of Birth user (Open Date Picker Dialog)
        bindingPersonalInformation.editUserDateOfBirth.setOnClickListener {
            bindingPersonalInformation.editUserDateOfBirth.also {
                CustomDateDialogTools.createDateDialog(
                    requireContext(),
                    ConstantsTools.FORMAT_DATE,
                    it
                )
            }
        }

        val bottomSheetView = bindingPersonalInformation.includeBottomSheetCitizenShip
        val bottomSheetRoot = bindingPersonalInformation.includeBottomSheetCitizenShip.root
        val bottomSheetCitizenShip = BottomSheetBehavior.from(bottomSheetRoot)
        val showKeyboard: InputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        var selectedItemSearchCitizenShip: String

        bindingPersonalInformation.editCitizenShip.setOnClickListener {
            // Show bottom_sheet
            bottomSheetCitizenShip.state = BottomSheetBehavior.STATE_EXPANDED

            // val tab = view.findViewById<TabLayout>(R.id.tab_layout_user_information)


            bottomSheetView.searchEditUserCitizenShip.requestFocus()

            // show KeyBoard
            showKeyboard.toggleSoftInput(InputMethodManager.RESULT_SHOWN, 0)

            // Click item
            bottomSheetView.searchEditUserCitizenShip.onItemClickListener =
                AdapterView.OnItemClickListener { parent, _,
                                                  position, _ ->
                    selectedItemSearchCitizenShip = parent.getItemAtPosition(position).toString()
                    bindingPersonalInformation.editCitizenShip.setText(
                        selectedItemSearchCitizenShip
                    )
                    // close keyboard
                    showKeyboard.toggleSoftInput(InputMethodManager.RESULT_HIDDEN, 0)

                    bottomSheetCitizenShip.state = BottomSheetBehavior.STATE_COLLAPSED
                    //   tab.isVisible=true
                }


//
//        bindingBottomSheet.imgSearch.setOnClickListener {
//            bindingBottomSheet.imgSearch.isVisible = false
//            bindingBottomSheet.searchTextInputLayoutCitizenShip.isVisible = true
//            bindingBottomSheet.searchEditUserCitizenShip.requestFocus()
//
//        }


        }


//
//        isCheckedInputTexts()
//
//


//
//
//    private fun isCheckedInputTextsAndNext() {
//        val errorText = resources.getString(R.string.text_error_input_edit_text)
//        when {
//
//            showBindingPersonalInformation.editUserFirstName.text.toString()
//                .isEmpty() -> {
//                showBindingPersonalInformation.textInputLayoutFirstName.isErrorEnabled = true
//                showBindingPersonalInformation.textInputLayoutFirstName.error =
//                    errorText
//
//            }
//            showBindingPersonalInformation.editUserSurname.text.toString().isEmpty() -> {
//                showBindingPersonalInformation.textInputLayoutSurname.isErrorEnabled = true
//                showBindingPersonalInformation.textInputLayoutSurname.error = errorText
//            }
//            showBindingPersonalInformation.editUserDateOfBirth.text.toString().isEmpty() -> {
//                showBindingPersonalInformation.textInputLayoutDateOfBirth.isErrorEnabled =
//                    true
//                showBindingPersonalInformation.textInputLayoutDateOfBirth.error = errorText
//            }
//            showBindingPersonalInformation.editUserGender.text.toString().isEmpty() -> {
//                showBindingPersonalInformation.textInputLayoutGender.isErrorEnabled =
//                    true
//                showBindingPersonalInformation.textInputLayoutGender.error = errorText
//            }
//            showBindingPersonalInformation.editUserCitizenShip.text.toString().isEmpty() -> {
//                showBindingPersonalInformation.textInputLayoutCitizenShip.isErrorEnabled =
//                    true
//                showBindingPersonalInformation.textInputLayoutCitizenShip.error = errorText
//            }
//            else -> showBindingPersonalInformation.root.let { view ->
//                sendData()
//                Navigation.findNavController(view)
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
//    private fun sendData() {
//        sharedViewModel.setFirstName(showBindingPersonalInformation.editUserFirstName.text.toString())
//        sharedViewModel.setSurName(showBindingPersonalInformation.editUserSurname.text.toString())
//        sharedViewModel.setDateOfBirth(showBindingPersonalInformation.editUserDateOfBirth.text.toString())
//        sharedViewModel.setGender(showBindingPersonalInformation.editUserGender.text.toString())
//        sharedViewModel.setCitizenShip(showBindingPersonalInformation.editUserCitizenShip.text.toString())
//    }
    }

    override fun onResume() {
        super.onResume()
        getPositionTabLayoutViewModel.sendPositionTabLayout(PERSONAL_INFORMATION_POSITION)
    }
}