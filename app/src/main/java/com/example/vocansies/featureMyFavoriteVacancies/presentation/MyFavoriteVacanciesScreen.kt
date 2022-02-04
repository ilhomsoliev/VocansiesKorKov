package com.example.vocansies.featureMyFavoriteVacancies.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vocansies.app.presentation.components.VacancyCard
import com.example.vocansies.core.entity.internal.Screen

@Composable
fun MyFavoriteVacanciesScreen(navController: NavController) {
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