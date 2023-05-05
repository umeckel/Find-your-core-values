package de.ulme.findyourcorevalues.ui.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import de.ulme.findyourcorevalues.R
import de.ulme.findyourcorevalues.ui.AppViewModelProvider
import de.ulme.findyourcorevalues.ui.navigation.YourValuesTopAppBar


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            YourValuesTopAppBar(
                title = stringResource(R.string.app_name),
            )
        },
    ) { innerPadding ->
        HomeBody(
            resultList = uiState.itemList,
            modifier = modifier.padding(innerPadding)
        )
    }
}

@Composable
fun HomeBody(
    resultList: List<String>,
    modifier: Modifier = Modifier,
) {
    if (resultList.isEmpty()) {
        Text("No results yet")
    } else {
        Text("Found ${resultList.size} yet")
    }

}