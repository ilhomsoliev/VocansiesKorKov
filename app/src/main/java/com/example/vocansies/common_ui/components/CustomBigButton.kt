package com.example.vocansies.common_ui.components

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun CustomBigButton(modifier:Modifier,text:String, currentColor:Color = Color(0xFF004E98),onClick:()->Unit) {
    Button(modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = currentColor),
        onClick = { onClick()}) {
        Text(text = text, fontSize = 18.sp, color = Color(0xFFFFFFFF))
    }
}