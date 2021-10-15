package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.MarginPageTransformer
import com.armenia_guide.adapters.ViewPagerAdapterUserInformation
import com.armenia_guide.databinding.FragmentUserInformationContainerBinding
import com.armenia_guide.tools.ConstantsTools
import com.armenia_guide.view_models.AuthorizationUserViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserInformationContainerFragment : Fragment() {
    private val userInformationBinding by lazy {
        FragmentUserInformationContainerBinding.inflate(
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


        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){

            if (viewPagerQuestionnaireUSer.currentItem !=
                ConstantsTools.PERSONAL_INFORMATION_POSITION) viewPagerQuestionnaireUSer.currentItem -= 1
            else {
                findNavController().popBackStack()
                sharedViewModel.changeItemCurrentPersonalInformation(ConstantsTools.PERSONAL_INFORMATION_POSITION)
            }
        }
    }
}