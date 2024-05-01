package com.timmerl.data.mapper

import com.timmerl.data.model.TeamDataModel
import com.timmerl.domain.model.TeamModel

class TeamDataModelMapperImpl : TeamDataModelMapper {
    override fun toModel(dataModel: TeamDataModel): TeamModel {
        return TeamModel(
            idTeam = dataModel.idTeam,
            strTeamBadge = dataModel.strTeamBadge
        )
    }
}
