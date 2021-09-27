package com.armenia_guide.ui.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationEmailBinding

class AuthorizationEmailFragment : Fragment() {
    private val bindingAuthorizationEmailFragment by lazy {
        FragmentAuthorizationEmailBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingAuthorizationEmailFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingAuthorizationEmailFragment.btnNextEmail.setOnClickListener {
            findNavController().navigate(R.id.action_authorizationEmailFragment_to_authorizationEnterPinFragment)
        }

    }


}