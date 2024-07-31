package com.example.madweek08firebase.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.madweek08firebase.navigation.AppNavigation
import com.example.madweek08firebase.navigation.TopLevelDestination
import com.example.madweek08firebase.ui.theme.MADWeek08FirebaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirebaseApp(
    startDestination: TopLevelDestination
) {
    MADWeek08FirebaseTheme {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "FirebaseApp") })
            }
        ) { innerPadding ->
            AppNavigation(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                navController = navController,
                startDestination = startDestination
            )
        }
    }
}