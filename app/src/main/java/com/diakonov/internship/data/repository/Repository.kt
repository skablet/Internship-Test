package com.diakonov.internship.data.repository

import com.diakonov.internship.data.api.RetrofitInstance
import com.diakonov.internship.model.main.Main
import retrofit2.Response

class Repository {

    suspend fun getAnimals(): Response<Main>{
        return RetrofitInstance.api.getAnimals()
    }
}