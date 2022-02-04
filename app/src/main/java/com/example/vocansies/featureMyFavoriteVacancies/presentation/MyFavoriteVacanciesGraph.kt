package com.example.vocansies.featureMyFavoriteVacancies.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.vocansies.core.entity.internal.Graph
import com.example.vocansies.core.entity.internal.Screen
import com.example.vocansies.featureHome.presentation.homeScreen.HomeScreen
import com.example.vocansies.featureHome.presentation.vacancyDescriptionScreen.VacancyDescriptionScreen

fun NavGraphBuilder.MyFavoriteVacanciesGraph(navController: NavController) {
    navigation(
        startDestination = Screen.MyFavoriteVacanciesScreen.route,
        route = Graph.MyFavoriteVacanciesGraph.route
    ) {
        composable(route = Screen.MyFavoriteVacanciesScreen.route) {
            MyFavoriteVacanciesScreen(navController = navController)
        }
        composable(route = Screen.DescriptionScreen.route) {
            VacancyDescriptionScreen(navController = navController)
        }
    }

}