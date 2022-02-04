package com.example.vocansies.featureAddVocancies.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.vocansies.core.entity.internal.Graph
import com.example.vocansies.core.entity.internal.Screen
import com.example.vocansies.featureHome.presentation.homeScreen.HomeScreen
import com.example.vocansies.featureHome.presentation.vacancyDescriptionScreen.VacancyDescriptionScreen

fun NavGraphBuilder.AddVacancyGraph(navController: NavController) {
    navigation(
        startDestination = Screen.AddVacancyScreen.route,
        route = Graph.AddVacancyGraph.route
    ) {
        composable(route = Screen.AddVacancyScreen.route) {
            AddVacancyScreen(navController = navController)
        }
        /*composable(route = Screen.RegistrationScreen.route) {
            RegistrationScreen(navController = navController)
        }*/
    }

}