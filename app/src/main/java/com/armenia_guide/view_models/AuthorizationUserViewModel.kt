package com.armenia_guide.view_models

import androidx.lifecycle.*
import com.armenia_guide.model.Repository
import com.armenia_guide.ui.biometry_access.entity.CountryPhoneNumberCodeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthorizationUserViewModel(val repo: Repository) : ViewModel() {

    private val _confirmEmailLiveData = MutableLiveData<String>()
    val confirmEmailLiveData: LiveData<String> = _confirmEmailLiveData

    private val _firstNameLiveData = MutableLiveData<String>()
    val firstNameLiveData: LiveData<String> = _firstNameLiveData

    private val _surNameLiveData = MutableLiveData<String>()
    val surNameLiveData: LiveData<String> = _surNameLiveData

    private val _dateOfBirthLiveData = MutableLiveData<String>()
    val dateOfBirthLiveData: LiveData<String> = _dateOfBirthLiveData

    private val _genderLiveData = MutableLiveData<String>()
    val genderLiveData: LiveData<String> = _genderLiveData

    private val _citizenShipLiveData = MutableLiveData<String>()
    val citizenShipLiveData: LiveData<String> = _citizenShipLiveData

    private val _phoneNumberLiveData = MutableLiveData<String>()
    val phoneNumberLiveData: LiveData<String> = _phoneNumberLiveData

    private val _countryPhoneCodeLiveData = MutableLiveData<String>()
    val countryPhoneCodeLiveData: LiveData<String> = _countryPhoneCodeLiveData

    private val _listCountryPhoneNumberCode = MutableLiveData<List<CountryPhoneNumberCodeModel>>()
    val listCountryPhoneNumberCode: LiveData<List<CountryPhoneNumberCodeModel>> =
        _listCountryPhoneNumberCode

    private val _isSelectedPositionCountryPhoneCode = MutableLiveData<Boolean>()
    val isSelectedPositionCountryPhoneCode: LiveData<Boolean> =
        _isSelectedPositionCountryPhoneCode


    private val _itemCurrentPersonalInformationLiveData = MutableLiveData<Int>(0)
    val itemCurrentPersonalInformationLiveData:LiveData<Int> = _itemCurrentPersonalInformationLiveData

    fun changeItemCurrentPersonalInformation(position:Int){

        _itemCurrentPersonalInformationLiveData.postValue(position)
    }

    fun getListCountryPhoneNumber() {

        viewModelScope.launch(Dispatchers.IO) {
            _listCountryPhoneNumberCode.postValue(repo.getListCountryPhoneNumbersCode())
        }
    }


    fun setFirstName(firstName: String) {
        _firstNameLiveData.postValue(firstName)
    }

    fun setSurName(surName: String) {
        _firstNameLiveData.postValue(surName)
    }

    fun setDateOfBirth(dateOfBirth: String) {
        _dateOfBirthLiveData.postValue(dateOfBirth)
    }

    fun setGender(gender: String) {
        _genderLiveData.postValue(gender)
    }

    fun setCitizenShip(citizenShip: String) {
        _citizenShipLiveData.postValue(citizenShip)
    }

    fun setConfirmEmail(confirmEmail: String) {
        _confirmEmailLiveData.postValue(confirmEmail)
    }

    fun setCountryPhoneCode(countryCode: String, isSelectedPosition: Boolean) {
        _countryPhoneCodeLiveData.postValue(countryCode)
        _isSelectedPositionCountryPhoneCode.postValue(isSelectedPosition)
    }

    fun setPhoneNumber(phoneNumber:String){
        _phoneNumberLiveData.postValue(phoneNumber)
    }
}