package com.example.vocansies.featureHome.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.widget.ConstraintLayout

@Composable
fun FinderBlock() {

    val searchText = remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        val (iconTitle, spacer, filter) = createRefs()
        Box(modifier = Modifier
            .constrainAs(iconTitle) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(spacer.start)
                width = Dimension.fillToConstraints
            }
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFC9C9C9))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(12.dp),
                    imageVector = Icons.Default.Search, contentDescription = ""
                )
                TextField(label = {
                    Text(text = "Type something...")
                }, value = searchText.value, onValueChange = {
                    searchText.value = it
                },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent, //hide the indicator
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
        }
        Spacer(modifier = Modifier
            .constrainAs(spacer) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(iconTitle.end)
                end.linkTo(filter.start)
            }
            .width(12.dp))
        Box(modifier = Modifier
            .constrainAs(filter) {
                top.linkTo(iconTitle.top)
                bottom.linkTo(iconTitle.bottom)
                start.linkTo(spacer.end)
                end.linkTo(parent.end)
                //height = Dimension.fillToConstraints
            }
            .size(56.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFC9C9C9))
            .clickable {

            }, contentAlignment = Alignment.Center) {
            Icon(imageVector = Icons.Default.Sort, contentDescription = "")
        }
    }
}