package com.timmerl.presentation.screen.showteams.model

sealed class TeamsScreenUiModel {

    data object LoadingLeagueUiModel : TeamsScreenUiModel()

    data class TeamsUiModel(
        val teams: List<TeamUiModel> = emptyList()
    ) : TeamsScreenUiModel()

    object EmptyScreen: TeamsScreenUiModel()
}

data class TeamUiModel(
    val id: String,
    val icon: String
)
