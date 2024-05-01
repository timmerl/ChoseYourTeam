package com.timmerl.presentation.screen.selectleague.model

sealed class LeagueScreenUiModel {

    data object LoadingLeagueUiModel : LeagueScreenUiModel()

    data class LeaguesUiModel(
        val leagues: List<LeagueUiModel> = emptyList()
    ) : LeagueScreenUiModel()
}

data class LeagueUiModel(
    val id: String,
    val name: String,
    val sport: String,
)
