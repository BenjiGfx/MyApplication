package com.example.myapplication.eigenerEntwurf.remote

import com.example.myapplication.eigenerEntwurf.model.Team
import com.example.myapplication.eigenerEntwurf.model.spielplandaten.SpTeam
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL_SP = "https://api.openligadb.de/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL_SP)
    .build()



object SpTeamApi {

    val spapiService: TeamApiService by lazy { retrofit.create(TeamApiService::class.java)}
}