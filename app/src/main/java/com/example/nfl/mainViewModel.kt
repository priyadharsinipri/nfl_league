package com.example.nfl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nfl.model.nflTeams
import com.example.nfl.model.sports
import com.example.nfl.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class mainViewModel(private val respository : Repository):ViewModel() {
    val myResponse: MutableLiveData<Response<nflTeams>> = MutableLiveData()
    fun getTeams() {
        viewModelScope.launch {
            val response = respository.getTeams()
            myResponse.value = response
        }
    }
}