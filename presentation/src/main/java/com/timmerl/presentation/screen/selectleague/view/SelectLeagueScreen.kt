package com.timmerl.presentation.screen.selectleague.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.timmerl.presentation.screen.selectleague.LeaguesViewModel
import com.timmerl.presentation.screen.selectleague.model.LeagueScreenUiModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SelectLeagueScreen(
    modifier: Modifier = Modifier,
    viewModel: LeaguesViewModel = getViewModel(),
    onLeagueItemClick: (String) -> Unit
) {
    val screenState = viewModel.screenState.collectAsState()
    when (val uiModel = screenState.value) {
        LeagueScreenUiModel.LoadingLeagueUiModel -> {
            LoadingView()
        }

        is LeagueScreenUiModel.LeaguesUiModel -> {
            SelectLeagueView(
                uiModel = uiModel,
                onAutocompleteValueChange = viewModel::autocomplete,
                onLeagueClick = {
//                    viewModel::selectLeague
                    onLeagueItemClick(it)
                }
            )
        }
    }
}
