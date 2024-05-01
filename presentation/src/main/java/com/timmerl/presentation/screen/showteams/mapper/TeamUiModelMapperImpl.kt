package com.timmerl.presentation.screen.showteams.mapper

import com.timmerl.domain.model.TeamModel
import com.timmerl.presentation.screen.showteams.model.TeamUiModel

class TeamUiModelMapperImpl : TeamUiModelMapper {

    override fun toUiModel(model: TeamModel): TeamUiModel {
        return TeamUiModel(
            id = model.idTeam,
            icon = model.strTeamBadge
        )
    }
}