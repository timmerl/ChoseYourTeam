package com.timmerl.presentation.screen.selectleague.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.timmerl.presentation.R

@Composable
fun LoadingView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.select_league_loading))
    }
}
