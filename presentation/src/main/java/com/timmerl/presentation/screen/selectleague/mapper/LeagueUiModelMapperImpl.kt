package com.timmerl.presentation.screen.selectleague.mapper

import com.timmerl.domain.model.LeagueModel
import com.timmerl.presentation.screen.selectleague.model.LeagueUiModel

class LeagueUiModelMapperImpl : LeagueUiModelMapper {
    override fun toUiModel(model: LeagueModel): LeagueUiModel {
        return LeagueUiModel(
            id = model.id,
            name = model.name,
            sport = model.sport
        )
    }
}