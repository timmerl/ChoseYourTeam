package com.timmerl.domain.usecase

import com.timmerl.domain.model.LeagueModel
import com.timmerl.domain.repository.LeagueRepository
import org.koin.core.annotation.InjectedParam


class FilterLeaguesByNameUseCaseImpl(
    @InjectedParam
    private val leagueRepository: LeagueRepository
) : FilterLeaguesByNameUseCase {
    override suspend operator fun invoke(search: String): List<LeagueModel> {
        return leagueRepository.getAllLeagues()
            .filter { league ->
                league.name.lowercase().contains(search.lowercase())
            }
    }
}
