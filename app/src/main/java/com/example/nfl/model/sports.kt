package com.example.nfl.model

data class sports(
    var id:String,
    var uid: String,
    var name:String,
    var slug: String,
    var leagues: List<Leagues>
)
