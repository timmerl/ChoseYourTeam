package com.timmerl.presentation.screen.showteams.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.timmerl.presentation.screen.showteams.ShowTeamsViewModel
import com.timmerl.presentation.screen.showteams.model.TeamsScreenUiModel

@Composable
fun ShowTeamsScreen(
    viewModel: ShowTeamsViewModel
) {
    val screenState = viewModel.screenState.collectAsState()
    when (val uiModel = screenState.value) {
        TeamsScreenUiModel.LoadingLeagueUiModel -> {
            LoadingView()
        }

        TeamsScreenUiModel.EmptyScreen -> {
            EmptyView()
        }

        is TeamsScreenUiModel.TeamsUiModel -> {
            ShowTeamsView(
                uiModel = uiModel,
            )
        }
    }
}