package com.example.myapplication.eigenerEntwurf.model

import retrofit2.http.Url

data class Team(
    val teamInfoId: Int,
    val teamName: String,
    val teamIconUrl: String,
    val points: Int,
    val goals: Int,
    val matches: Int,
    val won: Int,
    val lost: Int,
    val draw: Int,
    val goalDiff: Int,
)
