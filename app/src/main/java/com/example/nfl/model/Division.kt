package com.example.nfl.model

import com.google.gson.annotations.SerializedName

data class Division(
    @SerializedName("name") val name: String, // AFC East
    @SerializedName("standings") val standings: DivisionStandings
)
