package com.armenia_guide.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.armenia_guide.ui.personal_area.entity.ModelPersonalArea
import com.armenia_guide.ui.personal_area.RepositoryPersonalArea
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonalAreaViewModel(val repositoryPersonalArea: RepositoryPersonalArea) : ViewModel(){

    private val _listPersonalAreaLiveData = MutableLiveData<List<ModelPersonalArea>>()
    val listPersonalAreaLiveData :LiveData<List<ModelPersonalArea>> = _listPersonalAreaLiveData

    fun getListPersonalArea(){
        viewModelScope.launch (Dispatchers.IO) {
            _listPersonalAreaLiveData.postValue(repositoryPersonalArea.getListPersonalArea())
        }
    }
}