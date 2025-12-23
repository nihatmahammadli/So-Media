package com.example.so_media.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.so_media.ui.screens.IntroScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "intro" ) {
        composable("intro") {
            IntroScreen(
                onGetStartedClick = {
                    navController.navigate("main_app") {
                        popUpTo("intro") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}