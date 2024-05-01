package com.timmerl.presentation.screen.showteams.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.timmerl.presentation.screen.showteams.model.TeamsScreenUiModel


@Composable
fun ShowTeamsView(
    modifier: Modifier = Modifier,
    uiModel: TeamsScreenUiModel.TeamsUiModel,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(uiModel.teams) { team ->
            AsyncImage(
                model = team.icon,
                contentDescription = null,
            )
        }
    }
}


