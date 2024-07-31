package com.example.madweek08firebase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: TopLevelDestination
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier
    ){

    }
}