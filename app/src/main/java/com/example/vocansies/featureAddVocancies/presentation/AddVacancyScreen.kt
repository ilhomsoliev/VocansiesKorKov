package com.example.vocansies.featureAddVocancies.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vocansies.common_ui.components.AddVacancyTextField
import com.example.vocansies.common_ui.components.SpacerHeight

@Composable
fun AddVacancyScreen() {
    val title = remember{ mutableStateOf("")}
    val description = remember{ mutableStateOf("")}
    val price = remember{ mutableStateOf("")}
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 12.dp)){
        SpacerHeight(size = 12.dp)
        AddVacancyTextField(label = "Titiel", value = "") {

        }
    }
}