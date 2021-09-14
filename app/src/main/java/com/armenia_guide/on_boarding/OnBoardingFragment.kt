package com.armenia_guide.on_boarding


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.armenia_guide.adapters.ViewPagerAdapterOnBoarding
import com.armenia_guide.databinding.FragmentOnBoardingBinding
import com.google.android.material.tabs.TabLayoutMediator


class OnBoardingFragment : Fragment() {

    private lateinit var adapter: ViewPagerAdapterOnBoarding
    private var bindingOnBoardingFragment: FragmentOnBoardingBinding? = null
    val viewPager2 = bindingOnBoardingFragment?.viewPagerOnBoarding
    val tabLayout = bindingOnBoardingFragment?.tabLayoutOnBoarding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ViewPagerAdapterOnBoarding(requireActivity().supportFragmentManager, lifecycle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingOnBoardingFragment = FragmentOnBoardingBinding.inflate(inflater)

        if (tabLayout != null && viewPager2 != null) {

            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            }.attach()

        }







        return bindingOnBoardingFragment?.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingOnBoardingFragment = null
    }

}