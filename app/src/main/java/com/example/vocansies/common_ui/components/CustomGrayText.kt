package com.example.vocansies.common_ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CustomGrayText(modifier: Modifier,text:String,textAlign: TextAlign? = null) {
    Text(
        modifier = modifier,
        color = Color(0xFF848484),
        text = text,
        textAlign = textAlign
    )
}