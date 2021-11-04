package com.armenia_guide.ui.user_information

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.adapters.CountryCodeAdapterImpl
import com.armenia_guide.databinding.FragmentPhoneNumberBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.tools.TabLayoutUserInformation
import com.armenia_guide.ui.biometry_access.entity.CountryPhoneNumberCodeModel
import com.armenia_guide.view_models.AuthorizationUserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhoneNumberFragment : Fragment() {

    private lateinit var bindingPhoneNumber: FragmentPhoneNumberBinding
    private val sharedVieModel: AuthorizationUserViewModel by viewModel()
    private var isSelectedCountryPhoneCode = false
    private var selectedCountryPhoneCode = ""
    private lateinit var phoneNumber: String
    private var checkerPhoneNumber = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingPhoneNumber = FragmentPhoneNumberBinding.inflate(layoutInflater)

        TabLayoutUserInformation.tabLayoutFragments(bindingPhoneNumber.tabLayoutUserInformation)

        return bindingPhoneNumber.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingPhoneNumber.tabLayoutUserInformation.getTabAt(ConstantsTools.PHONE_NUMBER_POSITION)
            ?.select()


        /** check isNoteEmpty Input Phone Number **/
        phoneNumberTextWatcher()

        sharedVieModel.isSelectedPositionCountryPhoneCode.observe(viewLifecycleOwner, { selected ->
            isSelectedCountryPhoneCode = selected
        })
        sharedVieModel.countryPhoneCodeLiveData.observe(viewLifecycleOwner, { countryCode ->
            selectedCountryPhoneCode = countryCode

        })

        isCheckedInputText()

        checkerAndClick()

        bindingPhoneNumber.btnClose.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }

        bindingPhoneNumber.editInputPhoneNumberCode.setOnClickListener {
            sharedVieModel.getListCountryPhoneNumber()
            findNavController().navigate(R.id.action_phoneNumberFragment_to_citizenShipFragment)
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkerAndClick() {

        bindingPhoneNumber.btnNext.setOnClickListener {
            when {
                checkerPhoneNumber -> {

                    sendData()
                    findNavController()
                        .navigate(R.id.action_phoneNumberFragment_to_legalAddressFragment)
                }
                !checkerPhoneNumber -> {
                    bindingPhoneNumber.textInputPhoneNumber.error =
                        ConstantsTools.ERROR_EDIT_TEXT
                }
            }
        }
    }

    private fun isCheckedInputText() {
        bindingPhoneNumber.editInputPhoneNumber.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                phoneNumber = p0.toString()
                when {
                    bindingPhoneNumber.editInputPhoneNumber.text.isNullOrEmpty() -> {
                        bindingPhoneNumber.textInputPhoneNumber.error =
                            ConstantsTools.ERROR_EDIT_TEXT
                    }
                    else -> {
                        bindingPhoneNumber.textInputPhoneNumber.error = null
                        checkerPhoneNumber = true
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                checkerIsEmpty()
            }
        })

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkerIsEmpty() {
        if (checkerPhoneNumber) {
            bindingPhoneNumber.btnNext.background =
                resources.getDrawable(R.drawable.background_button_red, null)
        } else {
            bindingPhoneNumber.btnNext.background =
                resources.getDrawable(R.drawable.background_button_gray, null)
        }
    }


//    private fun buildRecyclerView() {
//        val countryCodeRecycler =
//            bindingPhoneNumber.includeBottomSheetSearchCountryCode.recyclerCountryPhoneCode
//
//        sharedVieModel.listCountryPhoneNumberCode.observe(
//            viewLifecycleOwner,
//            { listCountryPhoneNumber ->
//                countryCodeRecycler.setHasFixedSize(false)
//                val myAdapter =
//                    CountryCodeAdapterImpl(requireContext(), listCountryPhoneNumber, sharedVieModel)
//                countryCodeRecycler.adapter = myAdapter
//                countryCodeRecycler.layoutManager =
//                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//
//                bindingPhoneNumber.includeBottomSheetSearchCountryCode.searchEditCountryPhoneCode.addTextChangedListener(
//                    object : TextWatcher {
//                        override fun beforeTextChanged(
//                            s: CharSequence?,
//                            start: Int,
//                            count: Int,
//                            after: Int
//                        ) {
//                        }
//
//                        override fun onTextChanged(
//                            s: CharSequence?,
//                            start: Int,
//                            before: Int,
//                            count: Int
//                        ) {
//                        }
//
//                        override fun afterTextChanged(s: Editable?) {
//                            filter(s.toString(), listCountryPhoneNumber, myAdapter)
//                        }
//                    })
//            })
//    }

    private fun filter(
        text: String,
        numberCode: List<CountryPhoneNumberCodeModel>,
        adapterImpl: CountryCodeAdapterImpl
    ) {
        val filterList = mutableListOf<CountryPhoneNumberCodeModel>()
        for (element in numberCode) {
            if (element.country.lowercase().contains(text.lowercase())) {
                filterList.add(element)
            }
        }
        adapterImpl.filterList(filterList)
    }

    private fun phoneNumberTextWatcher() {
        bindingPhoneNumber.editInputPhoneNumberCode.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (bindingPhoneNumber.editInputPhoneNumberCode.text.toString().isNotEmpty()) {
                    bindingPhoneNumber.editInputPhoneNumberCode.error = null
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun sendData() {
        sharedVieModel.setPhoneNumber(bindingPhoneNumber.editInputPhoneNumberCode.text.toString())
    }
}