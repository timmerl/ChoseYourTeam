package com.timmerl.presentation.screen.showteams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timmerl.domain.usecase.GetTeamsUseCase
import com.timmerl.presentation.screen.selectleague.model.LeagueScreenUiModel
import com.timmerl.presentation.screen.showteams.mapper.TeamUiModelMapper
import com.timmerl.presentation.screen.showteams.model.TeamsScreenUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.InjectedParam

class ShowTeamsViewModel(
    @InjectedParam
    private val getTeamsUseCase: GetTeamsUseCase,
    @InjectedParam
    private val uiModelMapper: TeamUiModelMapper,
) : ViewModel() {

    private val _screenState =
        MutableStateFlow<TeamsScreenUiModel>(TeamsScreenUiModel.LoadingLeagueUiModel)
    val screenState: StateFlow<TeamsScreenUiModel> = _screenState

    fun init(leagueName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val updatedList = getTeamsUseCase.invoke(leagueName)
                .map { uiModelMapper.toUiModel(it) }
            _screenState.update {
                TeamsScreenUiModel.TeamsUiModel(
                    teams = updatedList
                )
            }
        }
    }
}
