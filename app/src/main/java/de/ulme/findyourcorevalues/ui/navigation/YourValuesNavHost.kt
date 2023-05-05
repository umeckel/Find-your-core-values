package de.ulme.findyourcorevalues.ui.navigation

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.ulme.findyourcorevalues.ui.screen.home.HomeScreen

@Composable
fun YourValuesNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable(route = "home") {
            HomeScreen()
        }
    }
}

@Composable
fun YourValuesTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
) {
    TopAppBar(title = { Text(title) }, modifier = modifier)
}
