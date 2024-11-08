package com.example.nfl.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nfl.model.team


@Dao
interface teamDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTeam(team: team)

    @Query(/* value = */ "SELECT * FROM team ORDER BY 'ASC' ")
    fun readAlldata():LiveData<List<team>>
}