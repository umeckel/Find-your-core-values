package de.ulme.findyourcorevalues.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import de.ulme.findyourcorevalues.R
import de.ulme.findyourcorevalues.ui.AppViewModelProvider
import de.ulme.findyourcorevalues.ui.navigation.NavigationDestination
import de.ulme.findyourcorevalues.ui.navigation.YourValuesTopAppBar
import de.ulme.findyourcorevalues.ui.theme.FindYourCoreValuesTheme

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}
@Composable
fun HomeScreen(
    navigateToSelection: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            YourValuesTopAppBar(
                title = stringResource(HomeDestination.titleRes),
            )
        },
    ) { innerPadding ->
        HomeBody(
            resultList = uiState.itemList,
            navigateToSelection = navigateToSelection,
            modifier = modifier.padding(innerPadding)
        )
    }
}

@Composable
fun HomeBody(
    resultList: List<String>,
    navigateToSelection: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (resultList.isEmpty()) {
        IntroductionBody(
            onStart = navigateToSelection
        )
    } else {
        Text("Found ${resultList.size} yet")
    }

}

@Composable
fun IntroductionBody(
    onStart: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.introduction_header),
                style = MaterialTheme.typography.h3,
            )
            Text(
                text = stringResource(R.string.introduction_body),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(8.dp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onStart,
            ) {
                Text(text = stringResource(R.string.start_vote))
            }
        }
    }
}

@Preview
@Composable
fun PreviewIntroductionBody(modifier: Modifier = Modifier) {
    FindYourCoreValuesTheme() {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            IntroductionBody({})
        }
    }
}
