package de.ulme.findyourcorevalues.ui.navigation

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.ulme.findyourcorevalues.ui.screen.home.HomeDestination
import de.ulme.findyourcorevalues.ui.screen.home.HomeScreen
import de.ulme.findyourcorevalues.ui.screen.valueSelection.ValueSelectionDestination
import de.ulme.findyourcorevalues.ui.screen.valueSelection.ValueSelectionScreen

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
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToSelection = {
                    navController.navigate(ValueSelectionDestination.route) },
            )
        }
        composable(route = ValueSelectionDestination.route) {
            ValueSelectionScreen()
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
