package com.example.vocansies.featureHome.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FiberManualRecord
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Point(text: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Icon(imageVector = Icons.Default.FiberManualRecord, contentDescription = null)
        Text(text = text)
    }
}