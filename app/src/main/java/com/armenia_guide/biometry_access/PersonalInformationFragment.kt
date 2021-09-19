package com.armenia_guide.biometry_access

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPersonalInformationBinding

class PersonalInformationFragment : Fragment() {
    private var showBindingPersonalInformation: FragmentPersonalInformationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingPersonalInformation =
            FragmentPersonalInformationBinding.inflate(inflater, container, false)
        return showBindingPersonalInformation?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showBindingPersonalInformation?.btnNext?.setOnClickListener{
               Navigation.findNavController(view).navigate(R.id.action_personalInformationFragment_to_phoneNumberFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showBindingPersonalInformation = null
    }
}