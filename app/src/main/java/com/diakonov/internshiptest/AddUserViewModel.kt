package com.diakonov.internshiptest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diakonov.internshiptest.db.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddUserViewModel: ViewModel() {

    fun insert(userModel: UserModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO){
        REPOSITORY.insertUser(userModel){
            onSuccess()
        }
    }
}