package com.armenia_guide.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.armenia_guide.R
import com.armenia_guide.ui.biometry_access.entity.CountryPhoneNumberCodeModel
import com.armenia_guide.view_models.AuthorizationUserViewModel


class CountryCodeAdapterImpl(
    val context: Context,
    private var listCountryCodeModel: List<CountryPhoneNumberCodeModel>,
    private val viewModel: AuthorizationUserViewModel
) :
    RecyclerView.Adapter<CountryCodeAdapterImpl.ViewHolderCountryCode>() {
    var selectedItemPos = -1
    var lastItemSelectedPos = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCountryCode {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.recycler_row_country_phone_code, parent, false)
        return ViewHolderCountryCode(view)
    }

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: ViewHolderCountryCode, position: Int) {
        val currentList = listCountryCodeModel[position]
        holder.countryName.text = currentList.country
        holder.phoneCode.text = currentList.codePhoneNumber

        if (position == selectedItemPos) {
            holder.countryName.setTextAppearance(R.style.SelectedTextAppearanceCountryName)
            holder.phoneCode.setTextAppearance(R.style.SelectedTextAppearancePhoneCode)
            viewModel.setCountryPhoneCode(currentList.codePhoneNumber, true)
        } else {
            holder.countryName.setTextAppearance(R.style.DefaultTextAppearanceCountryName)
            holder.phoneCode.setTextAppearance(R.style.DefaultTextAppearancePhoneCode)
        }
    }

    override fun getItemCount(): Int {
        return listCountryCodeModel.size
    }

    inner class ViewHolderCountryCode(view: View) : RecyclerView.ViewHolder(view) {

        val countryName: TextView = view.findViewById(R.id.country_name)
        val phoneCode: TextView = view.findViewById(R.id.phone_code)

        init {
            itemView.setOnClickListener {
                selectedItemPos = bindingAdapterPosition
                lastItemSelectedPos = if (lastItemSelectedPos == -1) {
                    selectedItemPos
                } else {
                    notifyItemChanged(lastItemSelectedPos)
                    selectedItemPos
                }
                notifyItemChanged(selectedItemPos)
            }

        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredList: List<CountryPhoneNumberCodeModel>) {
        listCountryCodeModel = filteredList
        notifyDataSetChanged()
    }
}