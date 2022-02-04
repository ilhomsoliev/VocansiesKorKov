package com.example.vocansies.featureAuthoration.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.vocansies.core.entity.internal.Graph
import com.example.vocansies.core.entity.internal.Screen
import com.example.vocansies.featureAuthoration.presentation.loginScreen.LoginScreen
import com.example.vocansies.featureAuthoration.presentation.registrationScreen.RegistrationScreen


fun NavGraphBuilder.AuthGraph(navController: NavController) {
    navigation(startDestination = Screen.LoginScreen.route,
        route = Graph.AuthGraph.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }
    }

}