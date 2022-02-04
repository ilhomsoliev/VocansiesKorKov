package com.example.vocansies.common_ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun SectionProfile(label: String, onClick: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = label)
        IconButton(onClick = {
            onClick()
        }) {
            Icon(Icons.Default.Edit, contentDescription = "")
        }
    }
}