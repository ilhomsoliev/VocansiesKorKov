package com.example.vocansies.common_ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun CustomUnderlinedText(text:String,onClick:()->Unit, fontSize: TextUnit = 16.sp) {
    Text(
        modifier = Modifier.clickable {
            onClick()
        },
        text = text,
        color = Color(0xFF1152FD),
        fontSize = fontSize,
        style = TextStyle(textDecoration = TextDecoration.Underline)
    )
}