package com.example.myapplication.eigenerEntwurf.remote

import com.example.myapplication.eigenerEntwurf.model.Data
import com.example.myapplication.eigenerEntwurf.model.Team
import com.example.myapplication.eigenerEntwurf.model.spielplandaten.SpData
import com.example.myapplication.eigenerEntwurf.model.spielplandaten.SpTeam
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.openligadb.de/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TeamApiService {

    @GET("getbltable/bl1/2023")
    suspend fun getTeam(): List<Team>

    @GET("getmatchdata/bl1/2023")
    fun getSpData(): List<SpData>



}

object TeamApi {

    val apiService: TeamApiService by lazy { retrofit.create(TeamApiService::class.java)}
}