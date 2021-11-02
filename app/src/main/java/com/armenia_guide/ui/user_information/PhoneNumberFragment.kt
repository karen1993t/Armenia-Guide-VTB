package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.armenia_guide.R
import com.armenia_guide.adapters.CountryCodeAdapterImpl
import com.armenia_guide.databinding.FragmentPhoneNumberBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.tools.TabLayoutUserInformation
import com.armenia_guide.ui.biometry_access.entity.CountryPhoneNumberCodeModel
import com.armenia_guide.view_models.AuthorizationUserViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhoneNumberFragment : Fragment() {

    private lateinit var bindingPhoneNumber:FragmentPhoneNumberBinding
    private val sharedVieModel: AuthorizationUserViewModel by viewModel()
    private var isSelectedCountryPhoneCode = false
    private var selectedCountryPhoneCode = ""
    private var inputPhoneNumber = ""

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

        val errorText = requireContext().resources.getString(R.string.text_error_input_edit_text)

        /** check isNoteEmpty Input Phone Number **/
        phoneNumberTextWatcher()

        sharedVieModel.isSelectedPositionCountryPhoneCode.observe(viewLifecycleOwner, { selected ->
            isSelectedCountryPhoneCode = selected
        })
        sharedVieModel.countryPhoneCodeLiveData.observe(viewLifecycleOwner, { countryCode ->
            selectedCountryPhoneCode = countryCode

        })

        bindingPhoneNumber.btnNext.setOnClickListener {
//            if (showBindingPhoneNumber.editInputPhoneNumberCode.text.toString().isEmpty()) {
//                showBindingPhoneNumber.editInputPhoneNumberCode.error = errorText
//            } else {
//                showBindingPhoneNumber.editInputPhoneNumberCode.error = null
            sendData()
            findNavController().navigate(R.id.action_phoneNumberFragment_to_legalAddressFragment)
            // sharedVieModel.changeItemCurrentPersonalInformation(ConstantsTools.USER_ADDRESS)
            //  }
        }

        bindingPhoneNumber.btnClose.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }

        bindingPhoneNumber.editInputPhoneNumberCode.setOnClickListener {
            sharedVieModel.getListCountryPhoneNumber()
        }

        /** create bottom sheet search country phone number code **/
        val bottomSheetIncludeSearchCountryCode =
            bindingPhoneNumber.includeBottomSheetSearchCountryCode
        val bottomSheetRootSearchCountryCode = bottomSheetIncludeSearchCountryCode.root
        val bottomSheetSearchCountryCode =
            BottomSheetBehavior.from(bottomSheetRootSearchCountryCode)


         val bottomSheetInclude = bindingPhoneNumber.includeBottomSheetSearchCountryCode


        bottomSheetIncludeSearchCountryCode.btnDoneSelectedCountryPhoneCode.setOnClickListener {
            if (isSelectedCountryPhoneCode && selectedCountryPhoneCode.isNotEmpty()) {
              //  bottomSheetInclude.editInputPhoneNumberCode.setText(selectedCountryPhoneCode)
               // bottomSheetSearchCountryCode.state = BottomSheetBehavior.STATE_COLLAPSED

            } else Toast.makeText(
                requireContext(),
                "Пожалуйста выберите код страны",
                Toast.LENGTH_SHORT
            ).show()

        }
        bottomSheetIncludeSearchCountryCode.btnCancel.setOnClickListener {
            bottomSheetSearchCountryCode.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        /** open bottom sheet search country phone number and input phone number **/
        bindingPhoneNumber.editInputPhoneNumberCode.setOnClickListener {
            bottomSheetSearchCountryCode.state = BottomSheetBehavior.STATE_EXPANDED
            buildRecyclerView()
        }
    }


//    @SuppressLint("SetTextI18n")
//    private fun createBottomSheetDialog() {
//        /** create bottom sheet input phone number **/
//        val bottomSheetInclude = showBindingPhoneNumber.includeBottomSheetPhoneNumber
//        val bottomSheetRoot = bottomSheetInclude.root
//        val bottomSheetPhoneNumber = BottomSheetBehavior.from(bottomSheetRoot)
//
//        bottomSheetPhoneNumber.state = BottomSheetBehavior.STATE_HALF_EXPANDED
//
//        /** close bottom Sheet Phone Number **/
//        bottomSheetInclude.btnDone.setOnClickListener {
//            inputPhoneNumber = bottomSheetInclude.editInputPhoneNumber.text.toString()
//            showBindingPhoneNumber.editPhoneNumber.setText("$selectedCountryPhoneCode$inputPhoneNumber")
//            bottomSheetPhoneNumber.state = BottomSheetBehavior.STATE_COLLAPSED
//        }
//
//        /** create bottom sheet search country phone number code **/
//        val bottomSheetIncludeSearchCountryCode =
//            showBindingPhoneNumber.includeBottomSheetSearchCountryCode
//        val bottomSheetRootSearchCountryCode = bottomSheetIncludeSearchCountryCode.root
//        val bottomSheetSearchCountryCode =
//            BottomSheetBehavior.from(bottomSheetRootSearchCountryCode)
//
//        bottomSheetIncludeSearchCountryCode.btnDoneSelectedCountryPhoneCode.setOnClickListener {
//            if (isSelectedCountryPhoneCode && selectedCountryPhoneCode.isNotEmpty()) {
//                bottomSheetInclude.editInputPhoneNumberCode.setText(selectedCountryPhoneCode)
//                bottomSheetSearchCountryCode.state = BottomSheetBehavior.STATE_COLLAPSED
//
//            } else Toast.makeText(
//                requireContext(),
//                "Пожалуйста выберите код страны",
//                Toast.LENGTH_SHORT
//            ).show()
//
//        }
//        bottomSheetIncludeSearchCountryCode.btnCancel.setOnClickListener {
//            bottomSheetSearchCountryCode.state = BottomSheetBehavior.STATE_COLLAPSED
//        }
//
//        /** open bottom sheet search country phone number and input phone number **/
//        bottomSheetInclude.editInputPhoneNumberCode.setOnClickListener {
//            bottomSheetSearchCountryCode.state = BottomSheetBehavior.STATE_EXPANDED
//
//            buildRecyclerView()
//        }
//    }

    private fun buildRecyclerView() {
        val countryCodeRecycler =
            bindingPhoneNumber.includeBottomSheetSearchCountryCode.recyclerCountryPhoneCode

        sharedVieModel.listCountryPhoneNumberCode.observe(
            viewLifecycleOwner,
            { listCountryPhoneNumber ->
                countryCodeRecycler.setHasFixedSize(false)
                val myAdapter =
                    CountryCodeAdapterImpl(requireContext(), listCountryPhoneNumber, sharedVieModel)
                countryCodeRecycler.adapter = myAdapter
                countryCodeRecycler.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

                bindingPhoneNumber.includeBottomSheetSearchCountryCode.searchEditCountryPhoneCode.addTextChangedListener(
                    object : TextWatcher {
                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) {
                        }

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {
                        }

                        override fun afterTextChanged(s: Editable?) {
                            filter(s.toString(), listCountryPhoneNumber, myAdapter)
                        }
                    })
            })
    }

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