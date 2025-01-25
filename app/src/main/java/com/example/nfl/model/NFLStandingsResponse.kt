package com.example.nfl.model

import com.google.gson.annotations.SerializedName

data class NFLStandingsResponse(
    @SerializedName("content") val content: Content
)
