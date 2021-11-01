package com.armenia_guide.ui.biometry_access.face_detect


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentDetectVideoSubmitBinding
import com.armenia_guide.view_models.BiometryFaceAndPassportDetectViewModel


class FaceDetectVideoSubmitFragment : Fragment(), View.OnClickListener {
    private val sharedViewModel: BiometryFaceAndPassportDetectViewModel by activityViewModels()
    private var showBindingSubmit: FragmentDetectVideoSubmitBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showBindingSubmit = FragmentDetectVideoSubmitBinding.inflate(inflater)
        return showBindingSubmit?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val videView = showBindingSubmit?.videoViewSubmit

        sharedViewModel.videoDetectUri.observe(viewLifecycleOwner, { uriVideoDetect ->
            showBindingSubmit?.videoViewSubmit?.setVideoURI(uriVideoDetect)

            videView?.setMediaController(android.widget.MediaController(requireContext()))
            videView?.requestFocus(0)
            videView?.start()
        })

        showBindingSubmit?.btnSubmit?.setOnClickListener(this)
        showBindingSubmit?.btnRetake?.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view) {
            showBindingSubmit?.btnSubmit -> showBindingSubmit?.root?.let {
                Navigation.findNavController(it)
                    .navigate(R.id.action_detectVideoSubmitFragment_to_checkBiometricsFragment)
            }
            showBindingSubmit?.btnRetake -> showBindingSubmit?.root?.let {
                Navigation.findNavController(it)
                    .navigate(R.id.action_detectVideoSubmitFragment_to_faceDetectVideoFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        showBindingSubmit = null
    }
}