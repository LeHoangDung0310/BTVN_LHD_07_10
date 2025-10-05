package com.example.btvn_lhd_07_10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.btvn_lhd_07_10.ui.theme.BTVN_LHD_07_10Theme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BTVN_LHD_07_10Theme {
                val navController = rememberNavController()
                var account by remember { mutableStateOf(Account()) }
                
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(
                            onLogin = { username, password ->
                                account = Account(
                                    username = username,
                                    password = password,
                                    email = "mail@email.com",
                                    phone = "+99 999 555 222",
                                    skype = "me007",
                                    web = "cssauthor.com/"
                                )
                                navController.navigate("profile")
                            }
                        )
                    }
                    composable("profile") {
                        ProfileScreen(
                            account = account,
                            onSettingClick = {
                                navController.popBackStack("login", inclusive = false)
                            },
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}

