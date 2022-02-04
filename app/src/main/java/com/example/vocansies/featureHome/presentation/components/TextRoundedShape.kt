package com.example.vocansies.featureHome.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextRoundedShape(
    text: String
) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(12.dp))
        .background(Color.Gray)
        .clickable {

        }) {
        Text(modifier = Modifier.padding(horizontal = 4.dp, vertical = 4.dp), text = text)
    }
}