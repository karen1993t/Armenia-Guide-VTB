package com.armenia_guide.ui.user_information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentDataInProcessingBinding

class DataInProcessingFragment : Fragment() {
    private lateinit var bindingDataInProcessing:FragmentDataInProcessingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingDataInProcessing = FragmentDataInProcessingBinding.inflate(layoutInflater)

        return bindingDataInProcessing.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingDataInProcessing.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_dataInProcessingFragment_to_biometrySuccessFragment)
        }
    }

}