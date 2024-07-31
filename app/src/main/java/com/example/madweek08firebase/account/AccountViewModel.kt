package com.example.madweek08firebase.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.madweek08firebase.datastore.DataStoreRepository
import com.example.madweek08firebase.navigation.TopLevelDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Annotate the class to indicate that it is a Hilt ViewModel
@HiltViewModel
class AccountViewModel @Inject constructor(
    // Inject the DataStoreRepository
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    // Define a private mutable state flow for the start destination
    private val _startDestination =
        MutableStateFlow<TopLevelDestination>(TopLevelDestination.Auth)

    // Expose the start destination as an immutable state flow
    val startDestination = _startDestination.asStateFlow()

    // Initialize the ViewModel
    init {
        // Launch a coroutine in the ViewModel's scope
        viewModelScope.launch {
            // Collect the authentication state from the repository
            dataStoreRepository.isAuthenticated.collect { isAuthenticated ->
                // Update the start destination based on the authentication state
                if (isAuthenticated) {
                    _startDestination.value = TopLevelDestination.Home
                } else {
                    _startDestination.value = TopLevelDestination.Auth
                }
            }
        }
    }

    // Function to save the authentication state using DataStoreRepository
    fun saveIsAuthenticated(isAuthenticated: Boolean) {
        // Launch a coroutine in the ViewModel's scope
        viewModelScope.launch {
            // Save the authentication state using the repository
            dataStoreRepository.saveIsAuthenticated(isAuthenticated = isAuthenticated)
        }
    }
}
