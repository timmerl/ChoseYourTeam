package com.timmerl.presentation.screen.selectleague.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.timmerl.presentation.R
import com.timmerl.presentation.screen.selectleague.model.LeagueScreenUiModel
import com.timmerl.presentation.screen.selectleague.model.LeagueUiModel


@Composable
fun SelectLeagueView(
    modifier: Modifier = Modifier,
    uiModel: LeagueScreenUiModel.LeaguesUiModel,
    onAutocompleteValueChange: (String) -> Unit,
    onLeagueClick: (name: String) -> Unit
) {
    Box(modifier.fillMaxSize()) {
        AutoCompleteField(
            modifier = Modifier.fillMaxSize(),
            uiModel = uiModel,
            onAutocompleteValueChange = onAutocompleteValueChange,
            onClick = onLeagueClick
        )
    }
}


@Composable
fun AutoCompleteField(
    modifier: Modifier = Modifier,
    uiModel: LeagueScreenUiModel.LeaguesUiModel,
    onAutocompleteValueChange: (String) -> Unit,
    onClick: (name: String) -> Unit
) {

    var text by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxSize()) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {
                text = it
                expanded = it.isNotEmpty()
                onAutocompleteValueChange(it)
            },
            singleLine = true,
            label = { Text(stringResource(id = R.string.select_league_selection_hint)) },
        )
        AnimatedVisibility(visible = expanded) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(uiModel.leagues) { league ->
                    LeagueItem(
                        modifier = Modifier.clickable { onClick(league.name) },
                        leagueUiModel = league,
                    )
                    Divider(color = Color.LightGray)
                }
            }
        }
    }
}

@Composable
fun LeagueItem(
    modifier: Modifier = Modifier,
    leagueUiModel: LeagueUiModel,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(modifier = Modifier, text = "League : ${leagueUiModel.name}")
        Text(modifier = Modifier, text = "Sport : ${leagueUiModel.sport}")
    }
}
