package com.example.nfl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nfl.model.Conference
import com.example.nfl.model.NFLStandingsResponse
import com.example.nfl.model.nflTeams
import com.example.nfl.model.sports
import com.example.nfl.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class mainViewModel(private val respository : Repository):ViewModel() {
    val myResponse: MutableLiveData<Response<nflTeams>> = MutableLiveData()
    fun getTeams() {
        viewModelScope.launch {
            val response = respository.getTeams()
            myResponse.value = response
        }
    }

     val standingsLiveData = MutableLiveData<List<Conference>>()

    fun getStandings() {

        // Call the API

        viewModelScope.launch {
            respository.refreshStandings().enqueue(object : Callback<NFLStandingsResponse> {
                override fun onResponse(
                    call: Call<NFLStandingsResponse>,
                    response: Response<NFLStandingsResponse>
                ) {
                    if (response.isSuccessful) {
                        val conferences = response.body()?.content?.standings?.conferences
                        standingsLiveData.value = conferences ?: emptyList()
                    }
                }

                override fun onFailure(call: Call<NFLStandingsResponse>, t: Throwable) {
                    standingsLiveData.value = emptyList()
                }
            })
        }
    }
}