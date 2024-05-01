package com.timmerl.domain.usecase

import com.timmerl.domain.model.LeagueModel

interface GetLeaguesUseCase {
    suspend operator fun invoke(
        search: String
    ): List<LeagueModel>
}
