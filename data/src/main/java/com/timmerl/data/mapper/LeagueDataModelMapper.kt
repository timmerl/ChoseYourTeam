package com.timmerl.data.mapper

import com.timmerl.data.model.LeagueDataModel
import com.timmerl.domain.model.LeagueModel

interface LeagueDataModelMapper {
    fun toModel(dataModel: LeagueDataModel): LeagueModel
}
