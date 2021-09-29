package com.armenia_guide.ui.personal_area.balance_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentBalanceUpBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class BalanceUpFragment : Fragment() {

    private val bindingBalanceUpFragment by lazy {
        FragmentBalanceUpBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingBalanceUpFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingBalanceUpFragment.toolbarBalanceUp.setNavigationIcon(R.drawable.ic_back_toolbar)





        bindingBalanceUpFragment.addCard.setOnClickListener {
            val bottomSheetAddCard = BottomSheetAddCardFragment()
           bottomSheetAddCard.show(parentFragmentManager,"")
        }
    }
}