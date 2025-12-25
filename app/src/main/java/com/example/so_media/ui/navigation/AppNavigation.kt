package com.example.so_media.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.so_media.R
import com.example.so_media.ui.components.BottomNavigationBar
import com.example.so_media.ui.screens.IntroScreen
import com.example.so_media.ui.theme.DarkBlue

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "intro") {
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
        composable("main_app") {
            MainAppContainer()
        }
    }
}

@Composable
@Preview
fun MainAppContainer() {
    var selectedTab by remember { mutableStateOf("Home") }

    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars, bottomBar = {
        BottomNavigationBar(
            selectedTab = selectedTab, onTabSelected = { newTab -> selectedTab = newTab })
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = {},
            containerColor = DarkBlue,
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier
                .offset(y = 50.dp)
                .size(60.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.float_icon),
                null,
                modifier = Modifier.size(30.dp)
            )
        }
    },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = Color.White
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {
                "Home" -> {}
                "Wallet" -> {}
                "Profile" -> {}
                "Settings" -> {}
            }
        }
    }
}