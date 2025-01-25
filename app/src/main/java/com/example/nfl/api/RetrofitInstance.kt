package com.example.nfl.api

import com.example.nfl.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(Constants.TEAM_URL).
                addConverterFactory(GsonConverterFactory.create()).build()
    }

    private val retrofitStandings by lazy {
        Retrofit.Builder().baseUrl(Constants.STANDINGS_URL).
        addConverterFactory(GsonConverterFactory.create()).build()
    }
    val standingsApi:StandingsApi by lazy {
        retrofitStandings.create(StandingsApi::class.java)
    }

    val api:TeamApi by lazy {
        retrofit.create(TeamApi::class.java)
    }

}