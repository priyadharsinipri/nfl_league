package com.example.nfl.model

import com.google.gson.annotations.SerializedName

data class Conference(
    @SerializedName("name") val name: String, // American Football Conference
    @SerializedName("groups") val groups: List<Division>
)