package com.example.vocansies.app.presentation.components

import android.system.Os.close
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(navController: NavController,onItemClicked:()->Unit) {
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
        navController.navigate(Screen.ProfileScreen.route)
        onItemClicked()
    })
    DrawerTextSection(text = "New resume", onClick = {})
    DrawerTextSection(text = "Add vocancies", onClick = {})
    Divider()
    DrawerTextSection(text = "Home", onClick = {})
    DrawerTextSection(text = "Resume", onClick = {})
    DrawerTextSection(text = "Interview", onClick = {})
    DrawerTextSection(text = "About app", onClick = {})
    DrawerTextSection(text = "Feedback", onClick = {})
    DrawerTextSection(text = "Suitable jobs", onClick = {})
}