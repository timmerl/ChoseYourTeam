package com.timmerl.domain.usecase

import com.timmerl.domain.model.TeamModel
import com.timmerl.domain.repository.TeamRepository
import org.koin.core.annotation.InjectedParam

class GetTeamsUseCaseImpl(
    @InjectedParam
    private val teamRepository: TeamRepository
) : GetTeamsUseCase {

    override suspend fun invoke(leagueName: String): List<TeamModel> {
        return teamRepository.getTeamFromLeague(leagueName)
            .filterIndexed { idx, _ ->
                idx % 2 == 0
            }
    }
}
