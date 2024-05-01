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
import com.timmerl.presentation.screen.showteams.ShowTeamsScreen
import com.timmerl.presentation.theme.ChoseYourLeagueTheme

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
                            route = "showTeams/{leagueId}",
                            arguments = listOf(
                                navArgument("leagueId") {
                                    type = NavType.StringType
                                }
                            )
                        ) { backstackEntry ->
                            ShowTeamsScreen(leagueId = backstackEntry.arguments?.getString("leagueId"))
                        }
                    }
                }
            }
        }
    }
}
