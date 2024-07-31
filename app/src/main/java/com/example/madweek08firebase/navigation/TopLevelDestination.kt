package com.example.madweek08firebase.navigation

sealed class TopLevelDestination(
    val route: String,
) {
    // pre auth routes
    data object Auth : TopLevelDestination(route = "auth") {

        data object SignIn : TopLevelDestination(route = "sign_in")

        data object SignUp : TopLevelDestination(route = "sign_up")
    }

    // post auth routes

    data object Home : TopLevelDestination(route = "home")

    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }


}