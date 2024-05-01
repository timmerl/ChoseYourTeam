package com.timmerl.domain.repository

import com.timmerl.domain.model.TeamModel

interface TeamRepository {

    suspend fun getTeamFromLeague(leagueName: String): List<TeamModel>
}
