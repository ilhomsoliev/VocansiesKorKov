package com.example.vocansies.app.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vocansies.core.entity.internal.Screen

@Composable
fun DrawerContent(navController: NavController, onItemClicked: (String) -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable {

        }) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), text = "KorKov", fontWeight = FontWeight.Bold
        )
    }
    Divider()
    DrawerTextSection(text = "Profile", onClick = {
        onItemClicked(Screen.ProfileScreen.route)
    })
    /*DrawerTextSection(text = "New resume", onClick = {
        onItemClicked(Screen.AddVacancyScreen.route)
    })*/
    DrawerTextSection(text = "Add vocancies", onClick = {
        onItemClicked(Screen.AddVacancyScreen.route)
    })
    Divider()
    DrawerTextSection(text = "Home", onClick = {
        onItemClicked(Screen.HomeScreen.route)
    })
    DrawerTextSection(text = "My favorite vacancies", onClick = {
        onItemClicked(Screen.HomeScreen.route)
    })
    DrawerTextSection(text = "Resume", onClick = {
        onItemClicked(Screen.ResumeScreen.route)
    })
    DrawerTextSection(text = "Interview", onClick = {

    })
    DrawerTextSection(text = "About app", onClick = {

    })
    DrawerTextSection(text = "Feedback", onClick = {

    })
    DrawerTextSection(text = "Suitable jobs", onClick = {

    })
}