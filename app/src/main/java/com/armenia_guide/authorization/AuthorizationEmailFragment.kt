package com.armenia_guide.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthorizationEmailBinding

class AuthorizationEmailFragment : Fragment() {
    var bindingAuthorizationEmailFragment:FragmentAuthorizationEmailBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingAuthorizationEmailFragment= FragmentAuthorizationEmailBinding.inflate(inflater)
        return bindingAuthorizationEmailFragment?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingAuthorizationEmailFragment?.btnNextEmail?.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_authorizationEmailFragment_to_authorizationEnterPinFragment)
        }
    }
}