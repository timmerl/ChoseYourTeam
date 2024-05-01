package com.timmerl.data.api

import com.timmerl.data.model.LeaguesDataModel
import retrofit2.Response
import retrofit2.http.GET

interface SportApi {
    @GET("all_leagues.php")
    suspend fun getAllLeagues(): Response<LeaguesDataModel>
}
