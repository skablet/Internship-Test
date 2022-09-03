package com.diakonov.internshiptest.db.repo

import androidx.lifecycle.LiveData
import com.diakonov.internshiptest.db.dao.UserDao
import com.diakonov.internshiptest.db.model.UserModel

class UserRealization(private val userDao: UserDao): UserRepo {

    override val allUsers: LiveData<List<UserModel>>
        get() = userDao.getAllUsers()

    override suspend fun deleteUser(userModel: UserModel, onSuccess: () -> Unit) {
        userDao.delete(userModel)
        onSuccess()
    }

    override suspend fun insertUser(userModel: UserModel, onSuccess: () -> Unit) {
        userDao.insert(userModel)
        onSuccess()
    }

    override suspend fun statusChange(userModel: UserModel, onSuccess: () -> Unit) {
        userDao.userChange(userModel)
        onSuccess()
    }
}