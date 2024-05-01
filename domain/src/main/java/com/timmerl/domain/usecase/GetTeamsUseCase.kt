package com.timmerl.domain.usecase

import com.timmerl.domain.model.TeamModel

interface GetTeamsUseCase {
    suspend operator fun invoke(leagueName: String): List<TeamModel>
}
