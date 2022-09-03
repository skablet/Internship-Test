package com.diakonov.internship.screens.mainInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diakonov.internship.data.repository.Repository
import com.diakonov.internship.model.main.Main
import kotlinx.coroutines.launch
import retrofit2.Response

class MainInfoViewModel: ViewModel() {

    var repo = Repository()
    val animalList: MutableLiveData<Response<Main>> = MutableLiveData()

    fun getAnimals(){
        viewModelScope.launch {
            animalList.value = repo.getAnimals()
        }
    }


}