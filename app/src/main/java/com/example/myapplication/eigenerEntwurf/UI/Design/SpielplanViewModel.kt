package com.example.myapplication.eigenerEntwurf.UI.Design

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.eigenerEntwurf.remote.SpRepository
import com.example.myapplication.eigenerEntwurf.remote.TeamApi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpielplanViewModel : ViewModel() {

    val sprepository = SpRepository(TeamApi)
    val spteam = sprepository.spdata // teams ist die constante im Repository.

    init {
        loadTeam()
    }

    fun loadTeam() {

        viewModelScope.launch(Dispatchers.IO) {
            sprepository.getSpData()
        }
    }
}
