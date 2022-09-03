package com.diakonov.internshiptest.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.diakonov.internshiptest.db.dao.UserDao
import com.diakonov.internshiptest.db.model.UserModel

@Database(entities = [UserModel::class], version = 1, exportSchema = false)
abstract class UserDb: RoomDatabase(){
    abstract fun getUserDao(): UserDao


    companion object{
        private var database: UserDb ?= null

        @Synchronized
        fun getInstance(context: Context): UserDb{
            return if (database == null){
                database = Room.databaseBuilder(context, UserDb::class.java, "db").build()
                database as UserDb
            }else{
                database as UserDb
            }
        }
    }


}