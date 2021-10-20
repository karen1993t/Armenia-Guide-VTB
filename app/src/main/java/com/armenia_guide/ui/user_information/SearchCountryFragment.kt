package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.widget.ToolbarWidgetWrapper
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import com.armenia_guide.R
import com.armenia_guide.databinding.FragmentSearchCountryBinding


class SearchCountryFragment : Fragment() {
    private val bindingSearchCountry: FragmentSearchCountryBinding by lazy {
        FragmentSearchCountryBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val toolbar =bindingSearchCountry.toolbar
        activity?.setActionBar(bindingSearchCountry.toolbar)
        val actionBar = activity?.actionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeButtonEnabled(true)

        setHasOptionsMenu(true)
       // toolbar.showOverflowMenu()

        return bindingSearchCountry.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_country, menu)
        val item = menu.findItem(R.id.action_search)
        val searchView = MenuItemCompat.getActionView(item) as SearchView
       //searchView.setOnQueryTextListener(this)
        item.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                // Do something when collapsed
              //  adapter.setFilter(mCountryModel)
                return true // Return true to collapse action view
            }

            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                // Do something when expanded
                return true // Return true to expand action view
            }
        })
    }

}