package com.armenia_guide.on_boarding

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.armenia_guide.adapters.ViewPagerAdapterOnBoarding
import com.armenia_guide.databinding.FragmentOnBoardingBinding



class OnBoardingFragment : Fragment() {

    private lateinit var adapter:ViewPagerAdapterOnBoarding
   private var bindingOnBoardingFragment:FragmentOnBoardingBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter= ViewPagerAdapterOnBoarding(requireActivity().supportFragmentManager,lifecycle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingOnBoardingFragment= FragmentOnBoardingBinding.inflate(inflater)





        return bindingOnBoardingFragment?.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingOnBoardingFragment = null
    }

}