package com.example.vocansies.featureProfile.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.vocansies.core.entity.internal.Graph
import com.example.vocansies.core.entity.internal.Screen
import com.example.vocansies.featureProfile.presentation.profileScreen.ProfileScreen

fun NavGraphBuilder.ProfileGraph(navController: NavController) {
    navigation(
        startDestination = Screen.ProfileScreen.route,
        route = Graph.ProfileGraph.route
    ) {
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        /*composable(route = Screen.DescriptionScreen.route) {
            VacancyDescriptionScreen(navController = navController)
        }*/
        /*composable(route = Screen.RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }*/
    }

}