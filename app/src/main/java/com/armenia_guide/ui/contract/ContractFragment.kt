package com.armenia_guide.ui.contract

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentContractBinding


class ContractFragment : Fragment() {
    private val bindingContract by lazy { FragmentContractBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return bindingContract.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingContract.btnAccept.setOnClickListener {
          //  findNavController().navigate(R.id.action_contractFragment_to_authorizationEmailFragment)
          //  findNavController().navigate(R.id.action_contractFragment_to_authorizationEnterPinFragment)
        }
        bindingContract.btnDecline.setOnClickListener {

        }


    }
}