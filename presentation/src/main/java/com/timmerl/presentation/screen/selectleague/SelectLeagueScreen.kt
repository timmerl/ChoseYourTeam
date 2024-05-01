package com.timmerl.presentation.screen.selectleague

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SelectLeagueScreen(
    modifier: Modifier = Modifier,
    onLeagueItemClick: (String) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Select your League",
            modifier = Modifier
        )
        Button(
            onClick = { onLeagueItemClick("todo") },
            content = {
                Text(
                    text = "click to go",
                    modifier = Modifier
                )
            }
        )
    }
}