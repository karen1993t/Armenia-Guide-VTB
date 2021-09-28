package com.armenia_guide.ui.personal_area.balance_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentBalanceUpBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class BalanceUpFragment : Fragment() {

    private val bindingBalanceUpFragment by lazy {
        FragmentBalanceUpBinding.inflate(layoutInflater)
    }

    private lateinit var bottomSheetAddCard: BottomSheetBehavior<ConstraintLayout>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingBalanceUpFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingBalanceUpFragment.toolbarBalanceUp.setNavigationIcon(R.drawable.ic_back_toolbar)

//        val bottomSheet = view.findViewById<ConstraintLayout>(R.id.bottomSheet)
//        bottomSheetAddCard = BottomSheetBehavior.from(bottomSheet)
        val  bottomSheetAddCard =  BottomSheetDialog(requireContext())
        bottomSheetAddCard.setContentView(R.layout.bottom_sheet_add_card)



        bindingBalanceUpFragment.addCard.setOnClickListener {
            bottomSheetAddCard.show()
        }
    }
}