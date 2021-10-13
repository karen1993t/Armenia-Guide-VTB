package com.armenia_guide.ui.personal_area

import android.os.Bundle
import android.text.InputType.*
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
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
    private val bindingBluePersonalArea by lazy { FragmentBluePersonalAreaBinding.inflate(layoutInflater) }
    private val viewModel: PersonalAreaViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  KeyboardTools.hideKeyboard()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //activity?.theme?.applyStyle(R.color.blue_personal_area,false)
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(),R.color.blue_personal_area)

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
        var count = 0
        bindingBluePersonalArea.imgShow.setOnClickListener {
            count++
            if (count%2 == 0){
                bindingBluePersonalArea.imgShow.setImageResource(R.drawable.ic_show_money)
                bindingBluePersonalArea.titleMoneyText.text = "***"
              //  bindingBluePersonalArea.titleMoneyText.transformationMethod = PasswordTransformationMethod()
            }else{
                bindingBluePersonalArea.imgShow.setImageResource(R.drawable.ic_hide_money)
               bindingBluePersonalArea.titleMoneyText.text = "25 252,54 RUB"


                bindingBluePersonalArea.titleMoneyText.text = RefactorTextColorsTools.refactorColorText(
                    requireContext(),
                    bindingBluePersonalArea.titleMoneyText,
                    R.color.money_title_end_color,
                    bindingBluePersonalArea.titleMoneyText.text.length - 7,
                    bindingBluePersonalArea.titleMoneyText.text.length
                )
//                bindingBluePersonalArea.titleMoneyText.inputType = TYPE_CLASS_TEXT


            }
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