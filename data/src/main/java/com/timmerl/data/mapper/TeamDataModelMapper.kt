package com.timmerl.data.mapper

import com.timmerl.data.model.TeamDataModel
import com.timmerl.domain.model.TeamModel

interface TeamDataModelMapper {
    fun toModel(dataModel: TeamDataModel): TeamModel
}
