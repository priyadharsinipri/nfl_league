package com.example.nfl.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "team")
data class team(
    @PrimaryKey
    var id:String,
                   var uid: String,
                   var name:String,
                   var slug: String,
                   var displayName: String,
                   var location: String,
                   var logos : List<Logos>)
