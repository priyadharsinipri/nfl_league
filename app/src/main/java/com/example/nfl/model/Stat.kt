package com.example.nfl.model

import com.google.gson.annotations.SerializedName


data class Stat(
    @SerializedName("shortDisplayName") val shortName: String, // e.g., W, L, T
    @SerializedName("displayValue") val displayValue: String, // e.g., 13, 4, 0
    @SerializedName("name") val name: String // e.g., wins, losses, ties
)
