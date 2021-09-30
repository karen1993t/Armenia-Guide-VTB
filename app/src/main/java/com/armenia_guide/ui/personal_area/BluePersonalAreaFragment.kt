package com.armenia_guide.ui.personal_area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.armenia_guide.R
import com.armenia_guide.adapters.PersonalAreaAdapter
import com.armenia_guide.databinding.FragmentBluePersonalAreaBinding
import com.armenia_guide.tools.RefactorTextColorsTools

class BluePersonalAreaFragment : Fragment() {
    private val bindingBluePersonalArea by lazy {
        FragmentBluePersonalAreaBinding.inflate(layoutInflater)
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
        bindingBluePersonalArea.replenish.setOnClickListener {
            findNavController().navigate(R.id.action_bluePersonalAreaFragment_to_balanceUpFragment)
        }


        val recycler = view.findViewById<RecyclerView>(R.id.recycler_view)
        val listData = listOf(
            ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "21:30", "-296 288 ₽"),
            ModelPersonalArea(R.drawable.ic_union, "Hilton Hotel", "20:30", "-196 435 ₽"),
            ModelPersonalArea(R.drawable.ic_rest, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
            ModelPersonalArea(R.drawable.ic_logo, "Income", "21:30", "+2 241 288 ₽"),
            ModelPersonalArea(R.drawable.ic_logo, "Hilton Hotel", "20:30", "-196 435 ₽"),
            ModelPersonalArea(R.drawable.ic_union, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
            ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "10:00", "-1 296 288 ₽"),

            ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "21:30", "-296 288 ₽"),
            ModelPersonalArea(R.drawable.ic_union, "Hilton Hotel", "20:30", "-196 435 ₽"),
            ModelPersonalArea(R.drawable.ic_rest, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
            ModelPersonalArea(R.drawable.ic_logo, "Income", "21:30", "+2 241 288 ₽"),
            ModelPersonalArea(R.drawable.ic_logo, "Hilton Hotel", "20:30", "-196 435 ₽"),
            ModelPersonalArea(R.drawable.ic_union, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
            ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "10:00", "-1 296 288 ₽"),
            ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "21:30", "-296 288 ₽"),
            ModelPersonalArea(R.drawable.ic_union, "Hilton Hotel", "20:30", "-196 435 ₽"),
            ModelPersonalArea(R.drawable.ic_rest, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
            ModelPersonalArea(R.drawable.ic_logo, "Income", "21:30", "+2 241 288 ₽"),
            ModelPersonalArea(R.drawable.ic_logo, "Hilton Hotel", "20:30", "-196 435 ₽"),
            ModelPersonalArea(R.drawable.ic_union, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
            ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "10:00", "-1 296 288 ₽"),
            ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "21:30", "-296 288 ₽"),
            ModelPersonalArea(R.drawable.ic_union, "Hilton Hotel", "20:30", "-196 435 ₽"),
            ModelPersonalArea(R.drawable.ic_rest, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
            ModelPersonalArea(R.drawable.ic_logo, "Income", "21:30", "+2 241 288 ₽"),
            ModelPersonalArea(R.drawable.ic_logo, "Hilton Hotel", "20:30", "-196 435 ₽"),
            ModelPersonalArea(R.drawable.ic_union, "Chateau Bordeaux", "12:30", "-10 288 ₽"),
            ModelPersonalArea(R.drawable.ic_path, "Moscow→Paris", "10:00", "-1 296 288 ₽"),
        )
        val customAdapter = PersonalAreaAdapter(requireContext(), listData)
        recycler.adapter = customAdapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
    }
}