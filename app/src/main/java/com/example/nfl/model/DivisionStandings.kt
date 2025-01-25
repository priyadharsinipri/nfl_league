package com.example.nfl.model

import com.google.gson.annotations.SerializedName

data class DivisionStandings(
    @SerializedName("entries") val entries: List<TeamEntry>
)
