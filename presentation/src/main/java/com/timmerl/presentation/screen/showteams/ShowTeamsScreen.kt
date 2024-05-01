package com.timmerl.presentation.screen.showteams

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShowTeamsScreen(
    modifier: Modifier = Modifier,
    leagueId: String?
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "This is Sparta -> id = $leagueId",
            modifier = Modifier
        )
    }
}