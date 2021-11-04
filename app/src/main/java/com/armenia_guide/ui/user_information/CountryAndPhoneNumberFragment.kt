package com.armenia_guide.ui.user_information

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.armenia_guide.R
import com.armenia_guide.adapters.CountryCodeAdapterImpl
import com.armenia_guide.databinding.FragmentCountryAndPhoneNumberBinding
import com.armenia_guide.ui.biometry_access.entity.CountryPhoneNumberCodeModel
import com.armenia_guide.view_models.AuthorizationUserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class CountryAndPhoneNumberFragment : Fragment() {
    private lateinit var bindingCountryAndPhoneNumber: FragmentCountryAndPhoneNumberBinding
    private val sharedVieModel: AuthorizationUserViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

     sharedVieModel.getListCountryPhoneNumber()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingCountryAndPhoneNumber = FragmentCountryAndPhoneNumberBinding.inflate(layoutInflater)

        bindingCountryAndPhoneNumber.toolbarSearchCitizen.inflateMenu(R.menu.menu_search_citizenship)
        bindingCountryAndPhoneNumber.toolbarSearchCitizen.setNavigationIcon(R.drawable.ic_btn_back)

        buildRecyclerView()

        return bindingCountryAndPhoneNumber.root
    }

    private fun buildRecyclerView() {
        val countryCodeRecycler = bindingCountryAndPhoneNumber.recyclerViewCitizenship

        sharedVieModel.listCountryPhoneNumberCode.observe(viewLifecycleOwner, { listCountryPhoneNumber ->
                countryCodeRecycler.setHasFixedSize(false)
               val myAdapter =
                    CountryCodeAdapterImpl(requireContext(), listCountryPhoneNumber, sharedVieModel)
                countryCodeRecycler.apply {
                    adapter = myAdapter
                    layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                }

            })
    }

    private fun filter(
        text: String,
        numberCode: List<CountryPhoneNumberCodeModel>,
        adapterImpl: CountryCodeAdapterImpl
    ) {
        val filterList = mutableListOf<CountryPhoneNumberCodeModel>()
        for (element in numberCode) {
            if (element.country.lowercase().contains(text.lowercase())) {
                filterList.add(element)
            }
        }
        adapterImpl.filterList(filterList)
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//
//        inflater.inflate(R.menu.menu_search_citizenship, menu)
//        val item = menu.findItem(R.id.action_search);
//        val searchView = item?.actionView as androidx.appcompat.widget.SearchView
//
//        searchView.setOnQueryTextListener(object :
//            androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(query: String?): Boolean {
//                Log.d("onQueryTextChange", "query: " + query)
//                if (query != null) {
//                    filter(query, list, myAdapter)
//                }
//
//                return false
//            }
//        })
//
//
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return super.onOptionsItemSelected(item)
//
//    }


}