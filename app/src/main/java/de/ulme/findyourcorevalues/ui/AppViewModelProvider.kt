package de.ulme.findyourcorevalues.ui

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import de.ulme.findyourcorevalues.data.DummyValueRepository
import de.ulme.findyourcorevalues.ui.screen.home.HomeViewModel
import de.ulme.findyourcorevalues.ui.screen.valueSelection.ValueSelectionViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for HomeViewModel
        initializer {
            HomeViewModel()
        }
        initializer {
            ValueSelectionViewModel(
                valueRepository = DummyValueRepository(),
            )
        }
    }
}