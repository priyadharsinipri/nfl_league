package com.example.nfl.repository

import com.example.nfl.api.RetrofitInstance
import com.example.nfl.model.nflTeams
import com.example.nfl.model.sports
import retrofit2.Response

class Repository {

    suspend fun getTeams() : Response<nflTeams>{
        return RetrofitInstance.api.getTeams()
    }
}