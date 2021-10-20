package com.armenia_guide.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PositionTabLayoutViewModel:ViewModel() {

    private val _positionTabLayoutLiveData = MutableLiveData<Int>()
    val  positionTabLayoutLiveData:LiveData<Int> =_positionTabLayoutLiveData
    fun sendPositionTabLayout(position:Int){
        _positionTabLayoutLiveData.postValue(position)
    }

}