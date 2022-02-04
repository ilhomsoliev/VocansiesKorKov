package com.example.vocansies.featureHome.presentation.vacancyDescriptionScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vocansies.featureHome.presentation.components.Point
import com.example.vocansies.featureHome.presentation.components.TextRoundedShape

@Composable
fun VacancyDescriptionScreen(
    navController: NavController
) {
    val verticalScrolable = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Text(text = "Respond", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
            .verticalScroll(verticalScrolable)
    ) {
        Text(text = "Title", fontWeight = FontWeight.Black, fontSize = 21.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Money", fontWeight = FontWeight.Black, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "description",
            modifier = Modifier.fillMaxWidth(),
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Requerments", fontWeight = FontWeight.Bold)
        Column(modifier = Modifier.fillMaxWidth()) {
            repeat(4) {
                Point(text = "Something anyway she knows")
            }
        }
        Text(text = "Usloviya", fontWeight = FontWeight.Bold)
        Column(modifier = Modifier.fillMaxWidth()) {
            repeat(4) {
                Point(text = "Something anyway she knows")
            }
        }
        Text(text = "time of publish", color = Color.Gray)
        Divider()
        Text(text = "Name of publisher", fontWeight = FontWeight.Bold)
        Text(text = "email of publisher", color = Color.Blue)
        Text(text = "Ask question to ")
        Column {
            repeat(4) {
                TextRoundedShape(text = "Is Vacancy still opened?")
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}