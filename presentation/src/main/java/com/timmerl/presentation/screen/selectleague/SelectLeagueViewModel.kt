package com.timmerl.presentation.screen.selectleague

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timmerl.domain.usecase.FilterLeaguesByNameUseCase
import com.timmerl.presentation.screen.selectleague.mapper.LeagueUiModelMapper
import com.timmerl.presentation.screen.selectleague.model.LeagueScreenUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.InjectedParam

class LeaguesViewModel(
    @InjectedParam
    private val autocompleteUseCase: FilterLeaguesByNameUseCase,
    @InjectedParam
    private val uiModelMapper: LeagueUiModelMapper,
) : ViewModel() {

    private val _screenState =
        MutableStateFlow<LeagueScreenUiModel>(LeagueScreenUiModel.LoadingLeagueUiModel)
    val screenState: StateFlow<LeagueScreenUiModel> = _screenState

    init {
        autocomplete("")
    }

    fun autocomplete(search: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val updatedList = autocompleteUseCase.invoke(search)
                .map { league ->
                    uiModelMapper.toUiModel(league)
                }
            _screenState.update {
                LeagueScreenUiModel.LeaguesUiModel(
                    leagues = updatedList
                )
            }
        }
    }

    fun selectLeague(id: String) {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

}
