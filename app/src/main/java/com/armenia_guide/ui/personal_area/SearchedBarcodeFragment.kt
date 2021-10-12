package com.armenia_guide.ui.personal_area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.armenia_guide.R
import com.armenia_guide.view_models.SendBarcodeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchedBarcodeFragment : Fragment() {
    val viewModel: SendBarcodeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_searched_barcode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView = view.findViewById<WebView>(R.id.web_view)

        viewModel.sendBarcodeLiveData.observe(viewLifecycleOwner, {
            webView.loadUrl("https://www.google.com/search?q=$it")
        })
    }
}