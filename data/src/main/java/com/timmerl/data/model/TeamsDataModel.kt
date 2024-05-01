package com.timmerl.data.model

data class TeamsDataModel(
    val teams: List<TeamDataModel>
)

data class TeamDataModel(
    val idTeam: String,
    val strTeamBadge: String
)
