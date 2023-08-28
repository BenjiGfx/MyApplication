package com.example.myapplication.eigenerEntwurf.UI.Design

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.eigenerEntwurf.remote.AppRepository
import com.example.myapplication.eigenerEntwurf.remote.TeamApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TabellenViewModel : ViewModel() {

    val repository = AppRepository(TeamApi)
    val team = repository.teams // teams ist die constante im Repository.

    init {
        loadTeam()
    }

    fun loadTeam() {

        viewModelScope.launch(Dispatchers.IO) {
            repository.getTeams()
        }
    }
}