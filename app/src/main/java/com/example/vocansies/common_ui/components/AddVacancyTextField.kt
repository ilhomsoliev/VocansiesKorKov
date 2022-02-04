package com.example.vocansies.common_ui.components

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AddVacancyTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Text(text = label)
    SpacerHeight(size = 8.dp)
    TextField(value = value, onValueChange = { onValueChange(it) })
}