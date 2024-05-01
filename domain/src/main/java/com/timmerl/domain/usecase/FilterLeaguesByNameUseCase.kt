package com.timmerl.domain.usecase

import com.timmerl.domain.model.LeagueModel

interface FilterLeaguesByNameUseCase {
    suspend operator fun invoke(
        search: String
    ): List<LeagueModel>
}
