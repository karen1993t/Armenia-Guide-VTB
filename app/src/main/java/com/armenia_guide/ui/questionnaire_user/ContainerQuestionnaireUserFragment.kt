package com.armenia_guide.ui.questionnaire_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.armenia_guide.R
import com.armenia_guide.adapters.ViewPagerAdapterOnBoarding
import com.armenia_guide.adapters.ViewPagerAdapterUserInformation
import com.armenia_guide.databinding.FragmentContainerQuestionnaireUserBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.view_models.AuthorizationUserViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContainerQuestionnaireUserFragment : Fragment() {
    private val userInformationBinding by lazy {
        FragmentContainerQuestionnaireUserBinding.inflate(
            layoutInflater
        )
    }
    private val sharedViewModel: AuthorizationUserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return userInformationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterViewModel =
            ViewPagerAdapterUserInformation(requireActivity().supportFragmentManager, lifecycle)
      val  tabLayoutQuestionnaireUSer = userInformationBinding.tabLayoutUserInformation
       val viewPagerQuestionnaireUSer = userInformationBinding.viewPagerOnUserInformation

        viewPagerQuestionnaireUSer.apply {
            isUserInputEnabled = false
            adapter = adapterViewModel
            TabLayoutMediator(tabLayoutQuestionnaireUSer, viewPagerQuestionnaireUSer) { _, _ ->
            }.attach()
            setPageTransformer(MarginPageTransformer(100))
        }

        sharedViewModel.itemCurrentPersonalInformationLiveData.observe(viewLifecycleOwner,
            {
                viewPagerQuestionnaireUSer.currentItem = it
            })


        requireActivity().onBackPressedDispatcher.addCallback(){

            if (viewPagerQuestionnaireUSer.currentItem !=
                ConstantsTools.PERSONAL_INFORMATION_POSITION) viewPagerQuestionnaireUSer.currentItem -= 1
            else {
                findNavController().popBackStack()
                sharedViewModel.changeItemCurrentPersonalInformation(ConstantsTools.PERSONAL_INFORMATION_POSITION)
            }
        }
    }
}