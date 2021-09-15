package com.armenia_guide.auth_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentSignInToEmailBinding
import com.armenia_guide.tools.CustomTools

class SignInToEmailFragment : Fragment() {
    private var showBindingSignInEmail: FragmentSignInToEmailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingSignInEmail = FragmentSignInToEmailBinding.inflate(inflater, container, false)
        return showBindingSignInEmail?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewInfo = showBindingSignInEmail?.textInfoSignInEmail
        if (textViewInfo?.text != null)
            textViewInfo.text =
                CustomTools.refactorColorText(
                    requireContext(),
                    textViewInfo,
                    R.color.color_red,
                    46,
                    textViewInfo.text.length
                )


    }


    override fun onDestroyView() {
        super.onDestroyView()
        showBindingSignInEmail = null
    }


}