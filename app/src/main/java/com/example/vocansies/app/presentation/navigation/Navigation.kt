package com.example.vocansies.app.presentation.navigation

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vocansies.app.presentation.components.DrawerContent
import com.example.vocansies.core.entity.internal.Graph
import com.example.vocansies.core.entity.internal.Screen
import com.example.vocansies.featureAddVocancies.presentation.AddVacancyGraph
import com.example.vocansies.featureAuthoration.presentation.AuthGraph
import com.example.vocansies.featureHome.presentation.HomeGraph
import com.example.vocansies.featureMyFavoriteVacancies.presentation.MyFavoriteVacanciesGraph
import com.example.vocansies.featureMyFavoriteVacancies.presentation.MyFavoriteVacanciesScreen
import com.example.vocansies.featureProfile.presentation.ProfileGraph
import com.example.vocansies.featureResume.presentation.ResumeGraph
import kotlinx.coroutines.launch

@Composable
fun Navigation() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            val title = remember {
                mutableStateOf("")
            }
            Log.d("Hello", "${currentDestination?.getCurrentRoute()} HERE")
            when (currentDestination?.getCurrentRoute()) {
                Screen.HomeScreen.route -> title.value = "KorKov"
                Screen.ProfileScreen.route -> title.value = "Profile"
                Screen.AboutAppScreen.route -> title.value = "About App"
                Screen.SuitableJobScreen.route -> title.value = "Suitable Job"
                Screen.InterviewScreen.route -> title.value = "Interview"
                Screen.AddVacancyScreen.route -> title.value = "Create Vacancy"
                Screen.MyFavoriteVacanciesScreen.route -> title.value = "Favorite Vacancies"
                Screen.ResumeScreen.route -> title.value = "Resume"
                else -> title.value = ""
            }
            if (currentDestination?.isCurrentDestinationHasBackArrow() == true) {
                TopAppBar(
                    title = {
                        Text(text = title.value)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(Icons.Default.ArrowBackIos, contentDescription = "")
                        }
                    }
                )
            } else if (currentDestination?.isCurrentDestinationDescriptionScreen() == true) {
                TopAppBar(
                    title = {
                        Text(text = title.value)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(Icons.Default.ArrowBackIos, contentDescription = "")
                        }
                    },
                    actions = {
                        val liked = remember { mutableStateOf(false) }
                        IconButton(onClick = {

                        }) {
                            Icon(Icons.Default.Share, contentDescription = "")
                        }
                        IconToggleButton(
                            checked = liked.value,
                            onCheckedChange = {
                                liked.value = it
                                if (liked.value) {

                                } else {

                                }
                            }
                        ) {
                            val tint: Color by animateColorAsState(
                                if (liked.value) Color(0xFF7BB661)
                                else Color.LightGray
                            )
                            Icon(
                                Icons.Filled.Favorite,
                                contentDescription = "Localized description",
                                tint = tint
                            )
                        }
                    }
                )
            } else if (currentDestination?.doesCurrentDestinationHaveTopBar() == true) {
                TopAppBar(
                    title = {
                        Text(text = title.value)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                scaffoldState.drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "")
                        }
                    }
                )
            }
        },
        drawerContent = {
            if (currentDestination?.doesCurrentDestinationHaveDrawer() == true) {
                DrawerContent(navController = navController, onItemClicked = { route ->
                    if (currentDestination.getCurrentRoute() != route) {
                        navController.navigate(route = route)
                    }
                    scope.launch {
                        scaffoldState.drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                })
            }

        }
    ) {

        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            // TODO Fix below
            startDestination = Graph.HomeGraph.route
        ) {
            AuthGraph(navController = navController)
            HomeGraph(navController = navController)
            ProfileGraph(navController = navController)
            AddVacancyGraph(navController = navController)
            ResumeGraph(navController = navController)
            MyFavoriteVacanciesGraph(navController = navController)
        }
    }
}

private fun NavDestination.doesCurrentDestinationHaveTopBar() =
    parent?.route != Graph.AuthGraph.route //&& route != Screen.Permissions.// route

private fun NavDestination.doesCurrentDestinationHaveDrawer() =
    route == Screen.HomeScreen.route || route == Screen.ProfileScreen.route ||
            route == Screen.ResumeScreen.route || Screen.AddVacancyScreen.route == route

private fun NavDestination.isCurrentDestinationDescriptionScreen() =
    route == Screen.DescriptionScreen.route

private fun NavDestination.getCurrentRoute() = route

private fun NavDestination.isCurrentDestinationHasBackArrow() =
    route == Screen.ArticleDescriptionScreen.route
