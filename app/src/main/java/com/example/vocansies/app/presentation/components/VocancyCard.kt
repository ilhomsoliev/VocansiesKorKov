package com.example.vocansies.app.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun VacancyCard(
    onClick: () -> Unit,
    onContactsClick: () -> Unit,
    onRespondClick: () -> Unit,
    onFavoriteClick: () -> Unit,
) {
    val insidePaddingStart = 8.dp
    val insidePaddingEnd = 8.dp
    Card(
        elevation = 6.dp
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFFFFFFF))
                .clickable {
                    onClick()
                }
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = insidePaddingStart,
                            end = insidePaddingEnd
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Android programmer",
                        fontWeight = FontWeight.Black
                    )
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .clickable {
                            onFavoriteClick()
                        }) {
                        Icon(
                            modifier = Modifier.padding(12.dp),
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = ""
                        )
                    }
                }

                Text(
                    modifier = Modifier.padding(
                        start = insidePaddingStart,
                        end = insidePaddingEnd
                    ), text = "120 000-250 000 $"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.padding(
                        start = insidePaddingStart,
                        end = insidePaddingEnd
                    ), text = "Moscow"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.padding(
                        start = insidePaddingStart,
                        end = insidePaddingEnd
                    ), text = "Name of company"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .padding(start = insidePaddingStart, end = insidePaddingEnd)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color(0xFFE7B365))
                ) {
                    Text(modifier = Modifier.padding(4.dp), text = "Without resume")
                }
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    modifier = Modifier.padding(
                        start = insidePaddingStart,
                        end = insidePaddingEnd
                    ), text = "Some description"
                )
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier.padding(
                        start = insidePaddingStart,
                        end = insidePaddingEnd
                    ), text = "date of publish"
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .padding(
                            start = insidePaddingStart,
                            end = insidePaddingEnd,
                            bottom = 12.dp
                        )
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFF4CAF50),
                                shape = RoundedCornerShape(30.dp)
                            )
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.White)
                            .weight(1f)
                            .clickable {
                                onContactsClick()
                            }
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            text = "Contacts",
                            textAlign = TextAlign.Center,
                            color = Color(0xFF4CAF50)
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color(0xFF4CAF50))
                            .weight(1f)
                            .clickable {
                                onRespondClick()
                            }
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            text = "Respond",
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}