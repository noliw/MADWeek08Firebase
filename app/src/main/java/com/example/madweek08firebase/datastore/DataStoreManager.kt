@file:JvmName("DataStoreManagerKt")

package com.example.madweek08firebase.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

// Extension property to initialize DataStore in the Context
val Context.dataStore by preferencesDataStore(name = "my_datastore")

// Define the DataStoreManager class and inject necessary dependencies
class DataStoreManager @Inject constructor(
    // Inject the application context
    @ApplicationContext private val context: Context
) {
    // Define a key for storing the authentication state as a boolean
    private val isAuthenticatedKey = booleanPreferencesKey("is_authenticated")

    // Create a Flow to read the authentication state from DataStore
    val isAuthenticated: Flow<Boolean> = context.dataStore.data.map { preference ->
        // Retrieve the value associated with the key, default to false if not found
        preference[isAuthenticatedKey] ?: false
    }

    // Function to save the authentication state to DataStore
    suspend fun saveIsAuthenticated(isAuthenticated: Boolean) {
        // Edit the DataStore to save the new authentication state
        context.dataStore.edit { preference ->
            // Store the value using the defined key
            preference[isAuthenticatedKey] = isAuthenticated
        }
    }
}
