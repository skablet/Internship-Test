package com.diakonov.internshiptest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.diakonov.internshiptest.db.UserDb
import com.diakonov.internshiptest.db.model.UserModel
import com.diakonov.internshiptest.db.repo.UserRealization

class UserViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoUser = UserDb.getInstance(context).getUserDao()
        REPOSITORY = UserRealization(daoUser)
    }
    fun getAllUsers(): LiveData<List<UserModel>>{
        return REPOSITORY.allUsers
    }
    suspend fun update(userModel: UserModel) = REPOSITORY.statusChange(userModel){}
}