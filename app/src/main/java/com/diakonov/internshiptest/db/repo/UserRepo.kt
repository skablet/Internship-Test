package com.diakonov.internshiptest.db.repo

import androidx.lifecycle.LiveData
import com.diakonov.internshiptest.db.model.UserModel

interface UserRepo {
    val allUsers: LiveData<List<UserModel>>
    suspend fun deleteUser (userModel: UserModel, onSuccess:() -> Unit)
    suspend fun insertUser(userModel: UserModel, onSuccess:() -> Unit)
    suspend fun statusChange(userModel: UserModel, onSuccess:() -> Unit)

}