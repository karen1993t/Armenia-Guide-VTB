package com.armenia_guide.ui.auth_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.armenia_guide.databinding.FragmentConfirmEmailBinding

class ConfirmEmailFragment : Fragment() {
    private var showBindingConfirmEmail: FragmentConfirmEmailBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingConfirmEmail = FragmentConfirmEmailBinding.inflate(inflater, container, false)
        return showBindingConfirmEmail?.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        showBindingConfirmEmail = null
    }


}