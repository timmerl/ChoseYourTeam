package com.timmerl.data.repository

import com.timmerl.data.api.SportApi
import com.timmerl.data.mapper.LeagueDataModelMapper
import com.timmerl.domain.model.LeagueModel
import com.timmerl.domain.repository.LeagueRepository
import org.koin.core.annotation.InjectedParam

class LeagueRepositoryImpl(
    @InjectedParam
    private val sportApi: SportApi,
    @InjectedParam
    private val mapper: LeagueDataModelMapper
) : LeagueRepository {

    private lateinit var leagues: List<LeagueModel>

    override suspend fun getAllLeagues(): List<LeagueModel> {
        if (::leagues.isInitialized.not()) {
            leagues = sportApi.getAllLeagues()
                .body()
                ?.leagues
                ?.map(mapper::toModel)
                ?: emptyList()
        }
        return leagues
    }
}
