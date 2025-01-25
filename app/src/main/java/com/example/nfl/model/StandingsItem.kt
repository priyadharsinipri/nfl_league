package com.example.nfl.model

sealed class StandingsItem {
    data class ZoneHeader(val zoneName: String) : StandingsItem()
    data class TeamRow(
        val teamName: String,
        val wins: String,
        val losses: String,
        val ties: String
    ) : StandingsItem()
}