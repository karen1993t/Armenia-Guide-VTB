package com.armenia_guide.ui.personal_area

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.armenia_guide.R
import com.armenia_guide.adapters.PersonalAreaAdapter
import com.armenia_guide.databinding.FragmentPersonalAreaBinding
import com.armenia_guide.view_models.PersonalAreaViewModel
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

class PersonalAreaFragment : Fragment() {

    private val bindingPersonalAreaFragment by lazy {
        FragmentPersonalAreaBinding.inflate(layoutInflater)
    }
    private  val viewModel: PersonalAreaViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingPersonalAreaFragment.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingPersonalAreaFragment.toolbarPersonalArea.setNavigationIcon(R.drawable.ic_back_toolbar)

        bindingPersonalAreaFragment.pay.setOnClickListener {
            findNavController().navigate(R.id.action_personalAreaFragment_to_payFragment)
        }
        bindingPersonalAreaFragment.replenish.setOnClickListener {
            findNavController().navigate(R.id.action_personalAreaFragment_to_balanceUpFragment)
        }

        val monthList = resources.getStringArray(R.array.month)
        val adapterMounts = ArrayAdapter(requireContext(), R.layout.drop_down_item_gender,
            R.id.text_view_drop_down,monthList)
        bindingPersonalAreaFragment.editMonth.setAdapter(adapterMounts)

        for (i in 0..Calendar.getInstance().time.month){
            bindingPersonalAreaFragment.month.hint =monthList[i]
        }

        bindingPersonalAreaFragment.editMonth.setOnClickListener {
            bindingPersonalAreaFragment.month.hint = ""

            bindingPersonalAreaFragment.editMonth.showDropDown()
        }

        val pieChart: PieChart = view.findViewById(R.id.pie_chart)

        val employess = ArrayList<PieEntry>()
        employess.add(PieEntry(296288f, 0))
        employess.add(PieEntry(45353f, 1))
        employess.add(PieEntry(50353f, 2))


        employess.add(PieEntry(45353f, 3))
        employess.add(PieEntry(57353f, 4))


        val dataSet = PieDataSet(employess, "Number Of Employees")

        val price = ArrayList<String>()
        price.add("AVIA")
        price.add("RESTAURANTS")
        price.add("HOTELS")
        price.add("ALCOHOL")
        price.add("OTHER")


        val arrayColors = resources.getIntArray(R.array.pie_chart_colors)
        val colors = ArrayList<Int>()
        for (element in arrayColors){
            colors.add(element)
        }

        dataSet.colors = colors

        val data = PieData(dataSet)

        pieChart.data = data
        pieChart.isRotationEnabled = false

        pieChart.animateXY(1000, 1000)


        val recycler = view.findViewById<RecyclerView>(R.id.recycler_view)
        viewModel.getListPersonalArea()
        viewModel.listPersonalAreaLiveData.observe(viewLifecycleOwner,{
            val listData =it
            val customAdapter = PersonalAreaAdapter(requireContext(), listData)
            recycler.adapter = customAdapter
            recycler.layoutManager = LinearLayoutManager(requireContext())
        })

        requireActivity().onBackPressedDispatcher.addCallback() {
          //  findNavController().navigate(R.id.action_personalAreaFragment_to_authorizationEmailFragment)
        }


    }
}