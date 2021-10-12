package com.armenia_guide.model

import android.content.Context
import com.armenia_guide.R
import com.armenia_guide.ui.biometry_access.entity.CountryPhoneNumberCodeModel

class LocalDataCountryPhoneNumberCodeImpl(val context: Context) : Repository {

    override suspend fun getListCountryPhoneNumbersCode(): List<CountryPhoneNumberCodeModel> {
        val countryCodeList = mutableListOf<CountryPhoneNumberCodeModel>()
        val listCountryName = context.resources.getStringArray(R.array.country_name)
        val listPhoneCode = context.resources.getStringArray(R.array.country_code)

        for (i in listCountryName.indices) {
            countryCodeList.add(i, CountryPhoneNumberCodeModel(listCountryName[i], listPhoneCode[i]))

        }
        return countryCodeList
    }
}