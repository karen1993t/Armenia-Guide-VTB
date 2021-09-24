package com.armenia_guide.ui.personal_area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPersonalAreaBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import java.util.*
import kotlin.collections.ArrayList

class PersonalAreaFragment : Fragment() {
    private var bindingPersonalAreaFragment: FragmentPersonalAreaBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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
        // bindingPersonal
        // AreaFragment?.toolbar?.inflateMenu(R.menu.ic_help_toolbar)


        bindingPersonalAreaFragment?.pay?.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_personalAreaFragment_to_payFragment)
        }


        val monthList = resources.getStringArray(R.array.month)
        val adapterMounts = ArrayAdapter(requireContext(), R.layout.drop_down_item_country,
            R.id.text_view_drop_down,monthList)
        bindingPersonalAreaFragment?.editMonth?.setAdapter(adapterMounts)

        for (i in 0..Calendar.getInstance().time.month){
            bindingPersonalAreaFragment?.month?.hint =monthList[i]
        }


        bindingPersonalAreaFragment?.editMonth?.setOnClickListener {
            bindingPersonalAreaFragment?.month?.hint = ""

            bindingPersonalAreaFragment?.editMonth?.showDropDown()
        }



        val pieChart: PieChart = view.findViewById(R.id.piechart)

        val NoOfEmp = ArrayList<PieEntry>()
        NoOfEmp.add(PieEntry(296288f, 0))
        NoOfEmp.add(PieEntry(45353f, 1))
        NoOfEmp.add(PieEntry(50353f, 2))
        NoOfEmp.add(PieEntry(45353f, 3))
        NoOfEmp.add(PieEntry(57353f, 4))


        val dataSet = PieDataSet(NoOfEmp, "Number Of Employees")

        val price = ArrayList<String>()
        price.add("AVIA")
        price.add("RESTAURANTS")
        price.add("HOTELS")
        price.add("ALCOHOL")
        price.add("OTHER")


        val colors = ArrayList<Int>()
        colors.add(resources.getColor(R.color.color_1_personal_area, null))
        colors.add(resources.getColor(R.color.color_2_personal_area, null))
        colors.add(resources.getColor(R.color.color_3_personal_area, null))
        colors.add(resources.getColor(R.color.color_4_personal_area, null))
        colors.add(resources.getColor(R.color.color_5_personal_area, null))


        dataSet.colors = colors


        val data = PieData(dataSet)


        pieChart.data = data

        pieChart.animateXY(1000, 1000)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingPersonalAreaFragment = null
    }
}