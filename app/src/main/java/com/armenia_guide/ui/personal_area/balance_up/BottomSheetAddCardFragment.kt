package com.armenia_guide.ui.personal_area.balance_up

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentBottomSheetAddCardBinding
import com.armenia_guide.tools.MaskEditTextTools
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetAddCardFragment : BottomSheetDialogFragment() {
    private val bindingBottomSheetAddCard by lazy {
        FragmentBottomSheetAddCardBinding.inflate(layoutInflater)
    }
    private var checkerCardNumber = false
    private var checkerCardData = false
    private var checkerCardCvc = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingBottomSheetAddCard.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        bindingBottomSheetAddCard.editNumberCardContainer.editText?.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                when {
                    bindingBottomSheetAddCard.editNumberCard.text?.isEmpty() == true ->
                        bindingBottomSheetAddCard.editNumberCardContainer.error =
                            resources.getString(R.string.error_message_input_card_number)
                    else -> {
                        bindingBottomSheetAddCard.editNumberCardContainer.error = null
                        checkerCardNumber = true
                    }
                }
            }
        })

        bindingBottomSheetAddCard.editDateCard.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                when {
                    bindingBottomSheetAddCard.editDateCard.text?.isEmpty() == true ->
                        bindingBottomSheetAddCard.editDateCardContainer.error =
                            resources.getString(R.string.error_message_input_card_date)
                    else -> {
                        bindingBottomSheetAddCard.editDateCardContainer.error = null
                        checkerCardData = true
                    }
                }
            }
        })

        bindingBottomSheetAddCard.editCvcCard.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                when {
                    bindingBottomSheetAddCard.editCvcCard.text?.isEmpty() == true ->
                        bindingBottomSheetAddCard.editCvcCardContainer.error =
                            resources.getString(R.string.error_message_input_card_cvc)
                    else -> {
                        bindingBottomSheetAddCard.editCvcCardContainer.error = null
                        checkerCardCvc = true
                    }
                }
            }
        })

        bindingBottomSheetAddCard.btnGetStarted.setOnClickListener {
            when {
                checkerCardNumber && checkerCardData && checkerCardCvc -> {
                    Toast.makeText(requireContext(), "Card Added success", Toast.LENGTH_SHORT)
                        .show()
                    dismiss()
                }
                !checkerCardNumber -> bindingBottomSheetAddCard.editNumberCardContainer.error =
                    resources.getString(R.string.error_message_input_card_number)
                !checkerCardData -> bindingBottomSheetAddCard.editDateCardContainer.error =
                    resources.getString(R.string.error_message_input_card_date)
                !checkerCardCvc -> bindingBottomSheetAddCard.editCvcCardContainer.error =
                    resources.getString(R.string.error_message_input_card_cvc)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val arrayMasks = arrayOf("____ ____ ____ ____", "__/__")
        MaskEditTextTools.createMaskEdit(0, arrayMasks, bindingBottomSheetAddCard.editNumberCard)
        MaskEditTextTools.createMaskEdit(1, arrayMasks, bindingBottomSheetAddCard.editDateCard)
    }
}