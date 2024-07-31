package com.example.madweek08firebase.datastore

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// Define the DataStoreRepository class and inject the DataStoreManager
class DataStoreRepository @Inject constructor(
    // Inject the DataStoreManager
    private val dataStoreManager: DataStoreManager
) {
    // Expose the isAuthenticated Flow from DataStoreManager
    val isAuthenticated: Flow<Boolean> = dataStoreManager.isAuthenticated

    // Function to save the authentication state using DataStoreManager
    suspend fun saveIsAuthenticated(isAuthenticated: Boolean) {
        dataStoreManager.saveIsAuthenticated(isAuthenticated = isAuthenticated)
    }
}
