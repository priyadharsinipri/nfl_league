package com.example.nfl.repository

import androidx.lifecycle.LiveData
import com.example.nfl.database.teamDao
import com.example.nfl.model.team

class teamRepository(private val teamDao: teamDao) {

    val readAllData:LiveData<List<team>> = teamDao.readAlldata()

    suspend fun addTeam(team: team){
        teamDao.addTeam(team)
    }
}