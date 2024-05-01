package com.timmerl.data.repository

import com.timmerl.data.api.SportApi
import com.timmerl.data.mapper.TeamDataModelMapper
import com.timmerl.domain.model.TeamModel
import com.timmerl.domain.repository.TeamRepository
import org.koin.core.annotation.InjectedParam

class TeamRepositoryImpl(
    @InjectedParam
    private val sportApi: SportApi,
    @InjectedParam
    private val mapper: TeamDataModelMapper
) : TeamRepository {

    override suspend fun getTeamFromLeague(leagueName: String): List<TeamModel> {
        return sportApi.getTeamsFromLeague(leagueName)
            .body()
            ?.teams
            ?.map(mapper::toModel)
            ?: emptyList()
    }
}
