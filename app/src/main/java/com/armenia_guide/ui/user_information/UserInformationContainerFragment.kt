package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.databinding.FragmentUserInformationContainerBinding
import com.armenia_guide.tools.ConstantsTools.COMMUNICATION_WITH_THE_BANK
import com.armenia_guide.tools.ConstantsTools.PERSONAL_INFORMATION_POSITION
import com.armenia_guide.tools.ConstantsTools.PHONE_NUMBER_POSITION
import com.armenia_guide.tools.ConstantsTools.USER_ADDRESS
import com.armenia_guide.tools.ConstantsTools.USER_PASSPORT
import com.armenia_guide.view_models.PositionTabLayoutViewModel
import com.google.android.material.tabs.TabLayout
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UserInformationContainerFragment : Fragment() {
    private lateinit var bindingUserInformation: FragmentUserInformationContainerBinding
    private val positionTabLayoutViewModel: PositionTabLayoutViewModel by sharedViewModel()
    private lateinit var tabLayoutQuestionnaireUSer: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingUserInformation = FragmentUserInformationContainerBinding.inflate(layoutInflater)
        tabLayoutQuestionnaireUSer = bindingUserInformation.tabLayoutUserInformation
        tabLayoutFragments()
        return bindingUserInformation.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        positionTabLayoutViewModel.positionTabLayoutLiveData.observe(viewLifecycleOwner, {
            when (it) {
                PERSONAL_INFORMATION_POSITION -> {
                    tabLayoutQuestionnaireUSer.getTabAt(PERSONAL_INFORMATION_POSITION)?.select()
                }
                PHONE_NUMBER_POSITION -> {
                    tabLayoutQuestionnaireUSer.getTabAt(PHONE_NUMBER_POSITION)?.select()
                }
                USER_ADDRESS -> {
                    tabLayoutQuestionnaireUSer.getTabAt(USER_ADDRESS)?.select()
                }
                USER_PASSPORT -> {
                    tabLayoutQuestionnaireUSer.getTabAt(USER_PASSPORT)?.select()
                }
                COMMUNICATION_WITH_THE_BANK -> {
                    tabLayoutQuestionnaireUSer.getTabAt(COMMUNICATION_WITH_THE_BANK)?.select()
                }
            }
        })

        onBackPressed()
    }

    private fun tabLayoutFragments() {
        with(tabLayoutQuestionnaireUSer) {
            addTab(newTab())
            addTab(newTab())
            addTab(newTab())
            addTab(newTab())
            addTab(newTab())
        }
    }

    private fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (tabLayoutQuestionnaireUSer.selectedTabPosition != PERSONAL_INFORMATION_POSITION) {
                tabLayoutQuestionnaireUSer.getTabAt(tabLayoutQuestionnaireUSer.selectedTabPosition - 1)
            } else {
                findNavController().popBackStack()
            }
        }
    }
}