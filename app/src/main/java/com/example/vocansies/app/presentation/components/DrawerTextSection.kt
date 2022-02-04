package com.example.vocansies.app.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerTextSection(
    text: String,
    onClick:()->Unit
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onClick()
        }) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), text = text
        )
    }
}