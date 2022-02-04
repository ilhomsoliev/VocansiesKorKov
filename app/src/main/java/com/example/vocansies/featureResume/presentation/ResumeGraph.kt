package com.example.vocansies.featureResume.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.vocansies.core.entity.internal.Graph
import com.example.vocansies.core.entity.internal.Screen
import com.example.vocansies.featureResume.presentation.articleDescriptionScreen.ArticleDescriptionScreen

fun NavGraphBuilder.ResumeGraph(navController: NavController) {
    navigation(startDestination = Screen.ResumeScreen.route,
        route = Graph.ResumeGraph.route) {
        composable(route = Screen.ResumeScreen.route) {
            ResumeScreen(navController = navController)
        }
        composable(route = Screen.ArticleDescriptionScreen.route) {
            ArticleDescriptionScreen(navController = navController)
        }
   }
}