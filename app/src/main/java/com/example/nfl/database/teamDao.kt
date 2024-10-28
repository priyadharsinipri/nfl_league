package com.example.nfl.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nfl.model.team


@Dao
interface teamDao {

    @Insert
    suspend fun addTeam(team: team)

    @Query(/* value = */ "SELECT * FROM teams ORDER BY 'ASC' ")
    fun readAlldata():LiveData<List<team>>
}