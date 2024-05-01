package com.timmerl.domain.repository

import com.timmerl.domain.model.LeagueModel

interface LeagueRepository {

    suspend fun getAllLeagues(): List<LeagueModel>
}
