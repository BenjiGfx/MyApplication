package com.example.myapplication.eigenerEntwurf.model.spielplandaten

data class SpData (

    val team1: SpTeam,
    val team2: SpTeam,
    val matchResults: List<SpTeam>
)