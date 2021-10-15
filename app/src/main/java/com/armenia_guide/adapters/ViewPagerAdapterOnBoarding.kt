package com.armenia_guide.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.armenia_guide.ui.on_boarding.*

class ViewPagerAdapterOnBoarding(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val listFragment = listOf(
        OnBoardingFragment1(),
        OnBoardingFragment2(),
        OnBoardingFragment3(),
        OnBoardingFragment4(),
        OnBoardingFragment5()
    )

    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
       return listFragment[position]
    }
}