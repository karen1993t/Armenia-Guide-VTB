package com.armenia_guide.view_models

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BiometryFaceAndPassportDetectViewModel : ViewModel() {

    // Uri video Detect
    private val _videoDetectUri = MutableLiveData<Uri>()
    val videoDetectUri: LiveData<Uri> = _videoDetectUri

    private val _passportPhotoDetectUri = MutableLiveData<Uri>()
    val passportPhotoDetectUri: LiveData<Uri> = _passportPhotoDetectUri

    fun setUriVideoDetect(uri:Uri){
        _videoDetectUri.postValue(uri)
    }
    fun  setUriPassportPhoto(uri:Uri){
        _passportPhotoDetectUri.postValue(uri)
    }

}