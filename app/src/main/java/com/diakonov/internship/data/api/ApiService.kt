package com.diakonov.internship.data.api

import com.diakonov.internship.model.main.Main
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET( "animals/rand/10")
    suspend fun getAnimals(): Response<Main>

}