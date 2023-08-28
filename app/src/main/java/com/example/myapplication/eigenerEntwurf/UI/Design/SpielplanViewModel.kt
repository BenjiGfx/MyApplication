package com.example.myapplication.eigenerEntwurf.UI.Design

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.eigenerEntwurf.remote.SpRepository
import com.example.myapplication.eigenerEntwurf.remote.SpTeamApi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpielplanViewModel : ViewModel() {

    val sprepository = SpRepository(SpTeamApi)
    val spteam = sprepository.spteams // teams ist die constante im Repository.

    init {
        loadTeam()
    }

    fun loadTeam() {

        viewModelScope.launch(Dispatchers.IO) {
            sprepository.getSpTeams()
        }
    }
}
