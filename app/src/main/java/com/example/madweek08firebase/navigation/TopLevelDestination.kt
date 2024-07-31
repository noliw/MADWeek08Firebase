package com.example.madweek08firebase.navigation

// Define a sealed class to represent top-level destinations in the app
sealed class TopLevelDestination(
    // Each destination has a route string
    val route: String,
) {
    // Define pre-authentication routes
    data object Auth : TopLevelDestination(route = "auth") {
        // Define SignIn route as a nested object within Auth
        data object SignIn : TopLevelDestination(route = "sign_in")
        // Define SignUp route as a nested object within Auth
        data object SignUp : TopLevelDestination(route = "sign_up")
    }

    // Define post-authentication routes
    data object Home : TopLevelDestination(route = "home")

    // Function to construct a route with arguments
    fun withArgs(vararg args: Any): String {
        // Build the route string with arguments
        return buildString {
            // Append the base route
            append(route)
            // Append each argument to the route
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
