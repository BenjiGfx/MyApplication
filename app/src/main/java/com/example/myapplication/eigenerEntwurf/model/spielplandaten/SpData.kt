package com.example.myapplication.eigenerEntwurf.model.spielplandaten

import com.squareup.moshi.Json

data class SpData (

    val team1: SpTeam,
    val team2: SpTeam,
    val matchResults: List<MatchResult>
)