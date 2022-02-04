package com.example.vocansies.featureResume.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vocansies.common_ui.components.SearchBlock
import com.example.vocansies.common_ui.components.SpacerHeight
import com.example.vocansies.common_ui.components.TitleArrowNext
import com.example.vocansies.core.entity.internal.Screen

@Composable
fun ResumeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        SearchBlock()
        SpacerHeight(size = 12.dp)
        LazyColumn {
            items(10) {
                TitleArrowNext(text = "Help", onClick = {
                    navController.navigate(Screen.ArticleDescriptionScreen.route)
                })
            }
        }
    }
}