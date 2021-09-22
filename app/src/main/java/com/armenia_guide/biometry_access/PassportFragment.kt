package com.armenia_guide.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPassportBinding

class PassportFragment : Fragment() {
    private var showBindingPassport: FragmentPassportBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingPassport = FragmentPassportBinding.inflate(inflater, container, false)
        return showBindingPassport?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBindingPassport?.btnNext?.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_passportFragment_to_communicationFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showBindingPassport = null
    }
}