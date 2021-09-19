package com.armenia_guide.auth_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.armenia_guide.databinding.FragmentCheckEmailBinding
import android.Manifest


class CheckEmailFragment : Fragment() {
    private var showBindingCheckEmail:FragmentCheckEmailBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingCheckEmail = FragmentCheckEmailBinding.inflate(inflater,container,false)
        return showBindingCheckEmail?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val requestPermissionNotification = registerForActivityResult(ActivityResultContracts.RequestPermission()){

        }

        requestPermissionNotification.launch(Manifest.permission.ACCESS_NETWORK_STATE)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        showBindingCheckEmail = null
    }
}