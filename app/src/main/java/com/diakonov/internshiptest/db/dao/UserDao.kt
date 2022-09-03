package com.diakonov.internshiptest.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.diakonov.internshiptest.db.model.UserModel

@Dao
interface UserDao {

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun userChange(userModel: UserModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userModel: UserModel)

    @Delete
    suspend fun delete(userModel: UserModel)

    @Query("Select * from user_table")
    fun getAllUsers(): LiveData<List<UserModel>>

}