package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentCitizenShipBinding

class CitizenShipFragment : Fragment() {
    private lateinit var bindingCitizenShip: FragmentCitizenShipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingCitizenShip = FragmentCitizenShipBinding.inflate(layoutInflater)

        activity?.setActionBar(bindingCitizenShip.toolbarSearchCitizen)
        bindingCitizenShip.toolbarSearchCitizen.setNavigationIcon(R.drawable.ic_btn_back)

        return bindingCitizenShip.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_citizenship, menu)

        val item = menu.findItem(R.id.action_search);
        val searchView = item?.actionView as SearchView

        // search queryTextChange Listener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                Log.d("onQueryTextChange", "query: " + query)
                return true
            }
        })

       super.onCreateOptionsMenu(menu,inflater)
    }
}