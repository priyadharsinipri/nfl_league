package com.example.nfl.model

data class Leagues(
    var id:Int,
    var uid: Int,
    var name:String,
    var slug: String,
    var teams: Teams
)
