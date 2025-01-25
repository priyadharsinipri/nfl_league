package com.example.nfl.model

import com.google.gson.annotations.SerializedName

data class TeamEntry(
    @SerializedName("stats") val stats: List<Stat>,
    val team: team?
)
