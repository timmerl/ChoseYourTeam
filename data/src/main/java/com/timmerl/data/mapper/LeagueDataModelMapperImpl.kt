package com.timmerl.data.mapper

import com.timmerl.data.model.LeagueDataModel
import com.timmerl.domain.model.LeagueModel

class LeagueDataModelMapperImpl : LeagueDataModelMapper {
    override fun toModel(dataModel: LeagueDataModel): LeagueModel {
        return LeagueModel(
            id = dataModel.idLeague,
            name = dataModel.strLeague,
            sport = dataModel.strSport,
            nameAlternate = dataModel.strLeagueAlternate ?: "",
        )
    }
}
