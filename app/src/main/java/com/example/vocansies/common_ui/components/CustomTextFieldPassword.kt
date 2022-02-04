package com.example.vocansies.common_ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CustomTextFieldPassword(
    modifier: Modifier,
    hintText: String,
    value: String,
    onValueChange: (String) -> Unit,
    onIconClick:()->Unit,
    passwordVisibility:Boolean
    ) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(text = hintText)
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            IconButton(onClick = {
                onIconClick()
            }) {
                Icon(
                    imageVector = if (passwordVisibility) Icons.Default.Visibility
                    else Icons.Default.VisibilityOff,
                    contentDescription = "visibility",
                    tint = Color.Gray
                )
            }
        },
        visualTransformation = if (passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None
    )
}