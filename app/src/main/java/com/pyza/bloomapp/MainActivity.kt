package com.pyza.bloomapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pyza.bloomapp.ui.theme.BloomAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloomAppTheme {
               val navController= rememberNavController()
                NavHost(navController = navController, startDestination = "home" ){
                    composable("welcome"){
                        WelcomeScreen(navController)
                    }
                    composable("login"){
                        LoginScreen(navController)
                    }
                    composable("home"){
                        HomeScreen()
                    }
                }
            }
        }
    }
}
