package de.ulme.findyourcorevalues.ui.screen.valueSelection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import de.ulme.findyourcorevalues.R
import de.ulme.findyourcorevalues.data.CoreValue
import de.ulme.findyourcorevalues.ui.AppViewModelProvider
import de.ulme.findyourcorevalues.ui.navigation.NavigationDestination
import de.ulme.findyourcorevalues.ui.navigation.YourValuesTopAppBar
import de.ulme.findyourcorevalues.ui.theme.FindYourCoreValuesTheme

object ValueSelectionDestination : NavigationDestination {
    override val route = "selection"
    override val titleRes = R.string.select_values
}

@Composable
fun ValueSelectionScreen(
    modifier: Modifier = Modifier,
    viewModel: ValueSelectionViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            YourValuesTopAppBar(
                title = stringResource(ValueSelectionDestination.titleRes),
            )
        },
    ) { innerPadding ->
        ValuesList(
            allValues = uiState.allValues,
            selectedValues = uiState.selectedValues,
            onSelect = { /* add value to selected values */ },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun ValuesList(
    allValues: List<CoreValue>,
    selectedValues: List<CoreValue>,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(allValues) { value ->
            ValueItem(
                value = value,
                isSelected = selectedValues.contains(value),
                onSelect = onSelect,
            )
            Divider()
        }
    }
}

@Composable
fun ValueItem(
    value: CoreValue,
    isSelected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card {
        Text(text = stringResource(value.label))
    }
}

@Preview
@Composable
fun PreviewSelectionScreen(modifier: Modifier = Modifier) {
    FindYourCoreValuesTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            ValuesList(
                allValues = listOf(
                    CoreValue(R.string.abenteuer),
                    CoreValue(R.string.achtsamkeit),
                    ),
                selectedValues = listOf(
                    CoreValue(R.string.abenteuer),
                ),
                onSelect = {/* do nothing */}
            )
        }
    }
}