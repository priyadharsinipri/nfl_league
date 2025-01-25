package com.example.nfl.model

import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("standings") val standings: StandingsData
)
