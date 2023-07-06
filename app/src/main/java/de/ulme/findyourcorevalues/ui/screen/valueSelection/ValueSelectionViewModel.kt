package de.ulme.findyourcorevalues.ui.screen.valueSelection

import androidx.lifecycle.ViewModel
import de.ulme.findyourcorevalues.data.ValueRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ValueSelectionViewModel(
    valueRepository: ValueRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ValueSelectionUiState(
        allValues = valueRepository.getAll(),
    ))
    val uiState: StateFlow<ValueSelectionUiState> = _uiState.asStateFlow()
}
