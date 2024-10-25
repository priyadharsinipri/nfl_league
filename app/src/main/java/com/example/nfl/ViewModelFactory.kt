package com.example.nfl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nfl.repository.Repository

class ViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return mainViewModel(repository) as T
    }

}