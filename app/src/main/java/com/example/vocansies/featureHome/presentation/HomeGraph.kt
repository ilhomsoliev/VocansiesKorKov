package com.example.vocansies.featureHome.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.vocansies.core.entity.internal.Graph
import com.example.vocansies.core.entity.internal.Screen
import com.example.vocansies.featureHome.presentation.homeScreen.HomeScreen
import com.example.vocansies.featureHome.presentation.vacancyDescriptionScren.VacancyDescriptionScreen

fun NavGraphBuilder.HomeGraph(navController: NavController) {
    navigation(
        startDestination = Screen.HomeScreen.route,
        route = Graph.HomeGraph.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.DescriptionScreen.route) {
            VacancyDescriptionScreen(navController = navController)
        }
        /*composable(route = Screen.RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }*/
    }

}