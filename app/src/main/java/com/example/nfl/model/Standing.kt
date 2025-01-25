package com.example.nfl.model

import com.google.gson.annotations.SerializedName

data class Standing(
    @SerializedName("team") val team: team,
    @SerializedName("stats") val stats: List<Stat>
)
