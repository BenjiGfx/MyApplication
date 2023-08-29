package com.example.myapplication.eigenerEntwurf.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.eigenerEntwurf.model.Team
import com.example.myapplication.eigenerEntwurf.model.spielplandaten.SpData
import com.example.myapplication.eigenerEntwurf.model.spielplandaten.SpTeam


const val SpTAG = "SpRepositoryTAG"

class SpRepository(val SpteamApi: TeamApi) {

    private val _currentspdata = MutableLiveData<List<SpData>>()
    val spdata: LiveData<List<SpData>>
        get() = _currentspdata


    suspend fun getSpData() {

        try {
            val newSpTeam = SpteamApi.apiService.getSpData()
            _currentspdata.postValue(newSpTeam)
        } catch (e: Exception) {
            Log.e(SpTAG, "Error loading Data from API: $e")
        }
    }
}

