package com.armenia_guide.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SendBarcodeViewModel:ViewModel() {

    private val _sendBarcodeLiveData = MutableLiveData<String>()
    val sendBarcodeLiveData: LiveData<String> = _sendBarcodeLiveData

    fun sendBarcode(string: String){
        _sendBarcodeLiveData.postValue(string)
    }
}