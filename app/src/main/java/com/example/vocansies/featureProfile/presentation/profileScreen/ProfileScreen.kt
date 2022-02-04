package com.example.vocansies.featureProfile.presentation.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.vocansies.app.presentation.components.VacancyCard
import com.example.vocansies.common_ui.components.SectionProfile
import com.example.vocansies.common_ui.components.SpacerHeight
import com.example.vocansies.common_ui.components.SpacerWidth
import com.example.vocansies.core.entity.internal.Screen

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileScreenViewModel = hiltViewModel()
) {
    val verticalScrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .verticalScroll(verticalScrollState)
    ) {
        SpacerHeight(size = 12.dp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            // horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Default.AddPhotoAlternate, contentDescription = "")
            }
            SpacerWidth(size = 12.dp)
            Column {
                SectionProfile(label = "Company name", onClick = {

                })
                SectionProfile(label = "Email", onClick = {

                })
            }
        }
        Text(modifier = Modifier.fillMaxWidth(), text = "Some description here")
        SpacerHeight(size = 8.dp)
        Text(text = "My vacancies", fontWeight = FontWeight.Bold)
        SpacerHeight(size = 8.dp)
        repeat(8) {
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