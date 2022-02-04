package com.example.vocansies.featureAddVocancies.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vocansies.common_ui.components.AddVacancyTextField
import com.example.vocansies.common_ui.components.CustomBigButton
import com.example.vocansies.common_ui.components.SpacerHeight

@Composable
fun AddVacancyScreen(navController: NavController) {
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val price = remember { mutableStateOf("") }
    val verticalScroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
            .verticalScroll(verticalScroll), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpacerHeight(size = 12.dp)
        AddVacancyTextField(label = "Title", value = title.value) {
            title.value = it
        }
        SpacerHeight(size = 12.dp)
        AddVacancyTextField(label = "Description", value = title.value) {
            title.value = it
        }
        SpacerHeight(size = 12.dp)
        AddVacancyTextField(label = "Price", value = title.value) {
            title.value = it
        }
        SpacerHeight(size = 12.dp)

        SpacerHeight(size = 12.dp)

        CustomBigButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), text = "Create new vacancy"
        ) {

        }

    }
}