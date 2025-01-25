package com.example.nfl.api

import android.telecom.Call
import com.example.nfl.model.NFLStandingsResponse
import com.example.nfl.model.nflTeams
import com.example.nfl.model.sports
import retrofit2.Response
import retrofit2.http.GET

interface TeamApi {

    @GET("nfl/teams")
    suspend fun getTeams():Response<nflTeams>

        @GET("core/nfl/standings?xhr=1")
        fun getStandings():retrofit2.Call<NFLStandingsResponse>

}