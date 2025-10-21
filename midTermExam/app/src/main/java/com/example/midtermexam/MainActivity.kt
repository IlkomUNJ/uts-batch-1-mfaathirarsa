package com.example.midtermexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.midtermexam.navigation.Screen
import com.example.midtermexam.ui.theme.MidTermExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var darkTheme by rememberSaveable { mutableStateOf(false) }

            MidTermExamTheme(darkTheme = darkTheme) {
                MidTermExamNavHost(
                    darkTheme = darkTheme,
                    onToggleTheme = { darkTheme = !darkTheme }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MidTermExamNavHost(
    darkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = { navController.navigate(Screen.Dashboard.route) },
                onToggleTheme = onToggleTheme,
                darkTheme = darkTheme
            )
        }

        composable(Screen.Dashboard.route) {
            DashboardScreen(
                onAddStudent = { navController.navigate(Screen.AddStudent.route) },
                onToggleTheme = onToggleTheme,
                darkTheme = darkTheme
            )
        }

        composable(Screen.AddStudent.route) {
            AddStudentScreen(
                onStudentAdded = { navController.popBackStack() },
                onToggleTheme = onToggleTheme,
                darkTheme = darkTheme
            )
        }
    }
}
