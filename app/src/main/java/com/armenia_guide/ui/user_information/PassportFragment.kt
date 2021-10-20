package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPassportBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.view_models.PositionTabLayoutViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PassportFragment : Fragment() {
    private lateinit var showBindingPassport: FragmentPassportBinding
    private val getPositionTabLayoutViewModel: PositionTabLayoutViewModel by sharedViewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        showBindingPassport = FragmentPassportBinding.inflate(inflater, container, false)
        return showBindingPassport.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBindingPassport.btnNext.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_passportFragment_to_communicationFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        getPositionTabLayoutViewModel.sendPositionTabLayout(ConstantsTools.USER_PASSPORT)
    }
}