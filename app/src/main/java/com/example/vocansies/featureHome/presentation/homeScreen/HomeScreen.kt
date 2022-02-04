package com.example.vocansies.featureHome.presentation.homeScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vocansies.app.presentation.components.VacancyCard
import com.example.vocansies.core.entity.internal.Screen
import com.example.vocansies.featureHome.presentation.components.FinderBlock

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(12.dp))
        FinderBlock()
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(modifier = Modifier.padding(horizontal = 12.dp)) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(8) {
                VacancyCard(
                    onClick = {
                        navController.navigate(Screen.DescriptionScreen.route)
                    },
                    onContactsClick = {

                    },
                    onRespondClick = {

                    },
                    onFavoriteClick = {

                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

        }
    }
}