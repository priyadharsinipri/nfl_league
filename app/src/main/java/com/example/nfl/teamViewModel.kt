package com.example.nfl

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.nfl.database.TeamDatabase
import com.example.nfl.model.TeamList
import com.example.nfl.model.team
import com.example.nfl.repository.teamRepository
import kotlinx.coroutines.launch

public class teamViewModel(application: Application):AndroidViewModel(application) {

    private val readAllData:LiveData<List<team>>
    private  val repository:teamRepository

    init{

        val teamDao = TeamDatabase.getDatabase(application).teamDao()
        repository = teamRepository(teamDao)
        readAllData = repository.readAllData
    }

    fun addTeam(team: team){
        viewModelScope.launch {
            repository.addTeam(team)
        }
    }

}