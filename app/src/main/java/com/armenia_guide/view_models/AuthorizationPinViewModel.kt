package com.armenia_guide.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthorizationPinViewModel() : ViewModel() {


    //Send Pin1 for compare Pin2
    private val _getPinLiveData = MutableLiveData<String>()
    val getPinLiveData: LiveData<String> = _getPinLiveData

    fun sendPin(string: String) {
        _getPinLiveData.postValue(string)
    }

    //Send Pin2 for compare PinPersonalArea
    private val _getPin2LiveData = MutableLiveData<String>()
    val getPin2LiveData: LiveData<String> = _getPin2LiveData

    fun sendPin2(string: String) {
        _getPin2LiveData.postValue(string)
    }
}