package com.armenia_guide.ui.auth_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.armenia_guide.databinding.FragmentCheckEmailBinding
import android.Manifest
import android.util.Log
import androidx.navigation.Navigation
import com.armenia_guide.R


class CheckEmailFragment : Fragment() {
    private var showBindingCheckEmail: FragmentCheckEmailBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingCheckEmail = FragmentCheckEmailBinding.inflate(inflater, container, false)
        return showBindingCheckEmail?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val requestPermissionNotification =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {
                Navigation.findNavController(view)
                    .navigate(R.id.action_checkEmailFragment_to_biometryAccessFragment)
            }

        requestPermissionNotification.launch(Manifest.permission.ACCESS_NOTIFICATION_POLICY)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        showBindingCheckEmail = null
    }
}