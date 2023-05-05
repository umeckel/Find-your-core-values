package de.ulme.findyourcorevalues

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import de.ulme.findyourcorevalues.ui.navigation.YourValuesNavHost

@Composable
fun YourValuesApp(
    navController: NavHostController = rememberNavController()
) {
    YourValuesNavHost(navController = navController)
}