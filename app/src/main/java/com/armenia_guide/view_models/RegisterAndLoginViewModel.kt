package com.armenia_guide.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.armenia_guide.tools.ConstantsTools

class RegisterAndLoginViewModel : ViewModel() {

    private val _positionAuthorizationFragmentsLiveData =
        MutableLiveData<Int>()
    val positionAuthorizationFragmentsLiveData: LiveData<Int> =
        _positionAuthorizationFragmentsLiveData







    fun setPositionFragment(position: Int) {
        _positionAuthorizationFragmentsLiveData.postValue(position)
    }
}