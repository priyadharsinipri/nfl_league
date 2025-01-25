package com.example.nfl.model

import com.google.gson.annotations.SerializedName

data class StandingsData(
    @SerializedName("name") val leagueName: String, // National Football League
    @SerializedName("groups") val conferences: List<Conference>
)
