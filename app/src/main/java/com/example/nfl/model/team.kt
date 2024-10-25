package com.example.nfl.model

data class team(   var id:String,
                   var uid: String,
                   var name:String,
                   var slug: String,
                   var displayName: String,
                   var location: String,
                   var logos : List<Logos>)
