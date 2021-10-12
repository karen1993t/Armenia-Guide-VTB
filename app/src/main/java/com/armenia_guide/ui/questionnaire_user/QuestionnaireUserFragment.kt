package com.armenia_guide.ui.questionnaire_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentQuestionnaireUserBinding

class QuestionnaireUserFragment : Fragment() {

    private val questionnaireUserBinding by lazy {
        FragmentQuestionnaireUserBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return questionnaireUserBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionnaireUserBinding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_questionnaireUserFragment_to_containerQuestionnaireUserFragment)
        }
    }

}