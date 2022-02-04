package com.example.vocansies.app.presentation.navigation

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
import com.example.vocansies.featureAuthoration.presentation.AuthGraph
import com.example.vocansies.featureHome.presentation.HomeGraph
import com.example.vocansies.featureProfile.presentation.ProfileGraph
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
            if (currentDestination?.isCurrentDestinationDescriptionScreen() == true) {
                TopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(onClick = {

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
            } else if (currentDestination?.isCurrentDestinationHasTopBar() == true) {
                TopAppBar(
                    title = { Text(text = "KorKov") },
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
            if (currentDestination?.isCurrentDestinationHasTopBar() == true) {
                DrawerContent(navController = navController, onItemClicked = {
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
            startDestination = Graph.AuthGraph.route
        ) {
            AuthGraph(navController = navController)
            HomeGraph(navController = navController)
            ProfileGraph(navController = navController)
        }
    }
}

private fun NavDestination.isCurrentDestinationHasTopBar() =
    parent?.route != Graph.AuthGraph.route //&& route != Screen.Permissions.// route

private fun NavDestination.isCurrentDestinationDescriptionScreen() =
    route == Screen.DescriptionScreen.route