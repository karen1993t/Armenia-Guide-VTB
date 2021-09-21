package com.armenia_guide.personal_area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPersonalAreaBinding

class PersonalAreaFragment : Fragment() {
    private var bindingPersonalAreaFragment: FragmentPersonalAreaBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingPersonalAreaFragment = FragmentPersonalAreaBinding.inflate(inflater)
        return bindingPersonalAreaFragment?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingPersonalAreaFragment?.toolbar?.setNavigationIcon(R.drawable.ic_back_toolbar)
       // bindingPersonalAreaFragment?.toolbar?.inflateMenu(R.menu.ic_help_toolbar)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingPersonalAreaFragment = null
    }
}