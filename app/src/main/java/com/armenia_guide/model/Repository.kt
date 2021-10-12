package com.armenia_guide.model

import com.armenia_guide.ui.biometry_access.entity.CountryPhoneNumberCodeModel

interface Repository {

   suspend fun getListCountryPhoneNumbersCode():List<CountryPhoneNumberCodeModel>
}