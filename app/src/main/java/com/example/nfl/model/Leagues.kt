package com.example.nfl.model

import com.google.gson.annotations.SerializedName

data class Leagues(
    var id:String,
    var uid: String,
    var name:String,
    var slug: String,
    @SerializedName("teams")
    var teamList: List<TeamList>
)
