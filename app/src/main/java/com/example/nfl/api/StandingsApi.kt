package com.example.nfl.api

import com.example.nfl.model.NFLStandingsResponse
import retrofit2.http.GET

interface StandingsApi {


        @GET("core/nfl/standings?xhr=1")
        fun getStandings():retrofit2.Call<NFLStandingsResponse>

}