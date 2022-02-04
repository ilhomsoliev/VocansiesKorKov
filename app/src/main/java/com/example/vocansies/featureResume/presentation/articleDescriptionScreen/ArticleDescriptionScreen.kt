package com.example.vocansies.featureResume.presentation.articleDescriptionScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vocansies.common_ui.components.SpacerHeight

@Composable
fun ArticleDescriptionScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Text(text = "Some tite here", fontWeight = FontWeight.Bold, fontSize = 21.sp)
        SpacerHeight(size = 16.dp)
        Text(
            text = "Some descripsadklfja sdklfjsdaklfjadsf jasdklfjkalsd jflksadjfklasjdfkljasdfkljadskl fjkdslaf jklsadjfklsad jfklasdjfkljasdfkljdsklfjsdaklfj sdkjf kldsj fklsadjf kljdskfjasdklfjsdkljfkal sdjfk jasdkl fjaksld jfklsadj fksdjkfj sdkfj ksadjf kash",
            fontSize = 16.sp
        )
    }
}