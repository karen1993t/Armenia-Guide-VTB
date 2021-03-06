package com.armenia_guide.ui.on_boarding


import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.armenia_guide.R
import com.armenia_guide.adapters.ViewPagerAdapterOnBoarding
import com.armenia_guide.databinding.FragmentOnBoardingBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingFragment : Fragment() {
    private val bindingOnBoarding by lazy {
        FragmentOnBoardingBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingOnBoarding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val requestPermission =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            }

        requestPermission.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        )

        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout_on_boarding)
        val viewPager2 = view.findViewById<ViewPager2>(R.id.view_pager_on_boarding)

        val adapter =
            ViewPagerAdapterOnBoarding(requireActivity().supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) { _, _ ->
        }.attach()
        viewPager2.scrollBarFadeDuration = 300
        viewPager2.setPageTransformer(MarginPageTransformer(100))


        bindingOnBoarding.btnGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_profileFragment)
        }
    }
}