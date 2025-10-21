package com.example.midtermexam.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Dashboard : Screen("dashboard")
    object AddStudent : Screen("add_student")
}
