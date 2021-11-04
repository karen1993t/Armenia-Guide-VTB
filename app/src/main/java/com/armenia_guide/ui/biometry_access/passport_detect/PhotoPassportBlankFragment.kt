package com.armenia_guide.ui.biometry_access.passport_detect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPhotoPassportBlankBinding

class PhotoPassportBlankFragment : Fragment() {
    private lateinit var bindingPhotoPassportBlank:FragmentPhotoPassportBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingPhotoPassportBlank = FragmentPhotoPassportBlankBinding.inflate(layoutInflater)
        return bindingPhotoPassportBlank.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingPhotoPassportBlank.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_photoPassportBlankFragment_to_detectPassportPhotoFragment)
        }
        bindingPhotoPassportBlank.btnClose.setOnClickListener {
            findNavController().navigate(R.id.profileFragment)
        }
    }
}