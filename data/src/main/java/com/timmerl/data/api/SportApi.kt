package com.timmerl.data.api

import com.timmerl.data.model.LeaguesDataModel
import com.timmerl.data.model.TeamsDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SportApi {
    @GET("all_leagues.php")
    suspend fun getAllLeagues(): Response<LeaguesDataModel>

    @GET("search_all_teams.php?l")
    suspend fun getTeamsFromLeague(@Query("l") name: String): Response<TeamsDataModel>
}
