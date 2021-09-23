package com.armenia_guide.ui.personal_area

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentPersonalAreaBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

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
        // bindingPersonalAreaFragment?.toolbar?.inflateMenu(R.menu.ic_help_toolbar)


        val pieChart: PieChart = view.findViewById(R.id.piechart)

        val NoOfEmp = ArrayList<PieEntry>()

        NoOfEmp.add(PieEntry(945f, 0))
        NoOfEmp.add(PieEntry(1040f, 1))
        NoOfEmp.add(PieEntry(1133f, 2))
        NoOfEmp.add(PieEntry(1240f, 3))
        NoOfEmp.add(PieEntry(1369f, 4))
        NoOfEmp.add(PieEntry(1487f, 5))
        NoOfEmp.add(PieEntry(1501f, 6))


        val dataSet = PieDataSet(NoOfEmp, "Number Of Employees")

        val year = ArrayList<String>()
        year.add("2008")
        year.add("2009")
        year.add("2010")
        year.add("2011")
        year.add("2012")
        year.add("2013")
        year.add("2014")

        val colors = ArrayList<Int>()
        colors.add(Color.RED)
        colors.add(Color.YELLOW)
        colors.add(Color.GREEN)
        colors.add(Color.BLUE)
        colors.add(Color.BLACK)
        colors.add(Color.MAGENTA)
        colors.add(Color.YELLOW)

        dataSet.colors = colors

        //prabelner
        dataSet.sliceSpace = 5f


        val data = PieData(dataSet)

        pieChart.data = data

        pieChart.animateXY(1000, 1000)


        pieChart.description.text = "Values 2021"


    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingPersonalAreaFragment = null
    }
}