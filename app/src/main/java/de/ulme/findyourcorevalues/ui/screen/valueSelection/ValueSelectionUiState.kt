package de.ulme.findyourcorevalues.ui.screen.valueSelection

import de.ulme.findyourcorevalues.data.CoreValue

data class ValueSelectionUiState(
    val allValues: List<CoreValue> = listOf(),
    val selectedValues: List<CoreValue> = listOf()
)