package com.example.myapplication.eigenerEntwurf.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.eigenerEntwurf.model.Team
import com.example.myapplication.eigenerEntwurf.model.spielplandaten.SpData
import com.example.myapplication.eigenerEntwurf.model.spielplandaten.SpTeam


const val SpTAG = "SpRepositoryTAG"

class SpRepository(val SpteamApi: SpTeamApi) {

    private val _currentspteams = MutableLiveData<List<SpTeam>>()
    val spteams: LiveData<List<SpTeam>>
        get() = _currentspteams


    suspend fun getSpTeams() {

        try {
            val newSpTeam = SpteamApi.spapiService.getSpTeam()
            _currentspteams.postValue(newSpTeam)
        } catch (e: Exception) {
            Log.e(SpTAG, "Error loading Data from API: $e")
        }
    }
}

