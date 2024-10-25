package com.example.nfl.api

import com.example.nfl.model.nflTeams
import com.example.nfl.model.sports
import retrofit2.Response
import retrofit2.http.GET

interface TeamApi {

    @GET("nfl/teams")
    suspend fun getTeams():Response<nflTeams>
}