package com.example.myapplication.eigenerEntwurf.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.eigenerEntwurf.model.Team

const val TAG = "AppRepositoryTAG"

class AppRepository(val teamApi: TeamApi) {

    private val _currentteams = MutableLiveData<List<Team>>()
    val teams: LiveData<List<Team>>
        get() = _currentteams


    suspend fun getTeams() {

        try {
            val newMeme = teamApi.apiService.getTeam()
            _currentteams.postValue(newMeme)
        } catch (e: Exception) {
            Log.e(TAG, "Error loading Data from API: $e")
        }
    }
}