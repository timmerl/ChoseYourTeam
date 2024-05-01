package com.timmerl.presentation.screen.showteams.mapper

import com.timmerl.domain.model.TeamModel
import com.timmerl.presentation.screen.showteams.model.TeamUiModel

interface TeamUiModelMapper {
    fun toUiModel(model: TeamModel): TeamUiModel
}