package com.armenia_guide.ui.personal_area

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.armenia_guide.R
import com.armenia_guide.adapters.PersonalAreaAdapter
import com.armenia_guide.databinding.FragmentBluePersonalAreaBinding
import com.armenia_guide.tools.KeyboardTools
import com.armenia_guide.tools.RefactorTextColorsTools
import com.armenia_guide.view_models.PersonalAreaViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BluePersonalAreaFragment : Fragment() {
    private val bindingBluePersonalArea by lazy {
        FragmentBluePersonalAreaBinding.inflate(layoutInflater)
    }
    private val viewModel: PersonalAreaViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KeyboardTools.hideKeyboard(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingBluePersonalArea.titleMoney.text = RefactorTextColorsTools.refactorColorText(
            requireContext(),
            bindingBluePersonalArea.titleMoney,
            R.color.money_title_end_color,
            bindingBluePersonalArea.titleMoney.text.length - 7,
            bindingBluePersonalArea.titleMoney.text.length
        )
        activity?.setActionBar(bindingBluePersonalArea.toolbarPersonalArea)
        return bindingBluePersonalArea.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingBluePersonalArea.toolbarPersonalArea.setNavigationIcon(R.drawable.ic_back_toolbar)

        bindingBluePersonalArea.pay.setOnClickListener {
            findNavController().navigate(R.id.action_bluePersonalAreaFragment_to_payFragment)
        }
        bindingBluePersonalArea.replenishBlue.setOnClickListener {
            findNavController().navigate(R.id.action_bluePersonalAreaFragment_to_balanceUpFragment)
        }



        val recycler = view.findViewById<RecyclerView>(R.id.recycler_view_blue)
        viewModel.getListPersonalArea()
        viewModel.listPersonalAreaLiveData.observe(viewLifecycleOwner, {
            val listData = it
            val customAdapter = PersonalAreaAdapter(requireContext(), listData)
            recycler.adapter = customAdapter
            recycler.layoutManager = LinearLayoutManager(requireContext())
        })

        requireActivity().onBackPressedDispatcher.addCallback() {
         //   findNavController().navigate(R.id.action_bluePersonalAreaFragment_to_authorizationEmailFragment)
        }


        //bindingBluePersonalArea.titleMoney.transformationMethod= PasswordTransformationMethod()
    }


}