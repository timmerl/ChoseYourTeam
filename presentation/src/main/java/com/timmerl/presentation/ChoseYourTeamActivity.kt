package com.timmerl.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.timmerl.presentation.screen.selectleague.view.SelectLeagueScreen
import com.timmerl.presentation.screen.showteams.ShowTeamsViewModel
import com.timmerl.presentation.screen.showteams.view.ShowTeamsScreen
import com.timmerl.presentation.theme.ChoseYourLeagueTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ChoseYourTeamActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChoseYourLeagueTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "selectLeague") {
                        composable("selectLeague") {
                            SelectLeagueScreen { leagueId ->
                                navController.navigate("showTeams/$leagueId")
                            }
                        }

                        composable(
                            route = "showTeams/{leagueName}",
                            arguments = listOf(
                                navArgument("leagueName") {
                                    type = NavType.StringType
                                }
                            )
                        ) { backstackEntry ->
                            val viewModel: ShowTeamsViewModel = getViewModel()
                            val leagueName = backstackEntry.arguments?.getString("leagueName") ?: ""
                            viewModel.init(leagueName)
                            ShowTeamsScreen(viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}
