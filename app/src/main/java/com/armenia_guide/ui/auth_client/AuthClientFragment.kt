package com.armenia_guide.ui.auth_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentAuthClientBinding


class AuthClientFragment : Fragment() {
    private var showBindingAuthClient : FragmentAuthClientBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingAuthClient = FragmentAuthClientBinding.inflate(inflater,container,false)
        return showBindingAuthClient?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showBindingAuthClient?.textSignInEmail?.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_authClientFragment_to_confirmEmailFragment)

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        showBindingAuthClient = null
    }

}