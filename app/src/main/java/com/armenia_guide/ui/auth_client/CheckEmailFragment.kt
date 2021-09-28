package com.armenia_guide.ui.auth_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.armenia_guide.databinding.FragmentCheckEmailBinding
import android.Manifest
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import kotlinx.coroutines.*


class CheckEmailFragment : Fragment() {
    private val showBindingCheckEmail by lazy { FragmentCheckEmailBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return showBindingCheckEmail.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val requestPermissionNotification =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) {
                //    findNavController().navigate(R.id.action_checkEmailFragment_to_biometryAccessFragment)

                if (it) {
                    showBindingCheckEmail.btnSendRepeat.setOnClickListener {
                        CoroutineScope(Dispatchers.Default).launch {                               //simulation request email link
                            delay(1000)
                            withContext(Dispatchers.Main) {
                                findNavController().navigate(R.id.action_checkEmailFragment_to_biometryAccessFragment)
                            }
                        }

                    }
                }
            }

        requestPermissionNotification.launch(Manifest.permission.ACCESS_NOTIFICATION_POLICY)


    }


}