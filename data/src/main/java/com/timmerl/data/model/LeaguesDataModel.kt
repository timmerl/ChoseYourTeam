package com.timmerl.data.model

data class LeaguesDataModel(
    val leagues: List<LeagueDataModel>
)

data class LeagueDataModel(
    val idLeague: String,
    val strLeague: String,
    val strSport: String,
    val strLeagueAlternate: String?,
)
