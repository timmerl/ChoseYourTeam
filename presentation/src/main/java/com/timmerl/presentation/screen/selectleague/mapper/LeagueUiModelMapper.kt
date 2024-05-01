package com.timmerl.presentation.screen.selectleague.mapper

import com.timmerl.domain.model.LeagueModel
import com.timmerl.presentation.screen.selectleague.model.LeagueUiModel

interface LeagueUiModelMapper {
    fun toUiModel(model: LeagueModel): LeagueUiModel
}