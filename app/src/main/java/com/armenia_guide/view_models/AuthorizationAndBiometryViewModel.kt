package com.armenia_guide.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthorizationAndBiometryViewModel : ViewModel() {


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
}