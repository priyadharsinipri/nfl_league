package com.example.nfl.model

data class Leagues(
    var id:String,
    var uid: String,
    var name:String,
    var slug: String,
    var teams: List<Teams>
)
