package com.armenia_guide.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.armenia_guide.ui.biometry_access.CommunicationFragment
import com.armenia_guide.ui.biometry_access.LegalAddressFragment
import com.armenia_guide.ui.biometry_access.PassportFragment
import com.armenia_guide.ui.user_information.PersonalInformationFragment
import com.armenia_guide.ui.user_information.PhoneNumberFragment

class ViewPagerAdapterUserInformation(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val listFragment = listOf(
        PersonalInformationFragment(),
        PhoneNumberFragment(),
        LegalAddressFragment(),
        PassportFragment(),
        CommunicationFragment()
    )

    override fun getItemCount(): Int {
        return listFragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return listFragment[position]
    }
}