package com.example.vocansies.featureAuthoration.presentation.registrationScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.vocansies.common_ui.components.CustomBigButton
import com.example.vocansies.common_ui.components.CustomTextField
import com.example.vocansies.common_ui.components.CustomTextFieldPassword
import com.example.vocansies.common_ui.components.LoadingIndicator
import com.example.vocansies.core.entity.internal.Graph
import com.example.vocansies.core.entity.screenState.RegisterResponseState

@Composable
fun RegistrationScreen(
    navController: NavController,
    viewModel: RegistrationViewModel = hiltViewModel()
) {

    val nameState by viewModel.name
    val phoneState by viewModel.phone
    val passwordState by viewModel.password
    val passwordVisibilityState by viewModel.passwordVisibility

    val stateRegistration: RegisterResponseState by viewModel.stateLogin
    val stateToken by viewModel.stateToken



    LoadingIndicator(isLoading = stateRegistration.isLoading)

    if (!stateRegistration.isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE5E5E5))
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "KorKov",
                    textAlign = TextAlign.Center,
                    fontSize = 100.sp,
                    color = Color.Black
                )
            }
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxSize()
            ) {
                Row {
                    CustomTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 36.dp, end = 36.dp),
                        hintText = "Email",
                        value = phoneState,
                        onValueChange = {
                            viewModel.setPhone(it)
                        },
                        isNumberOption = true
                    )
                }
                CustomTextFieldPassword(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 36.dp, end = 36.dp),
                    hintText = "Пароль",
                    value = passwordState,
                    onValueChange = {
                        viewModel.setPassword(it)
                    },
                    onIconClick = {
                        viewModel.setPasswordVisibility(!passwordVisibilityState)
                    },
                    passwordVisibility = passwordVisibilityState
                )
                CustomBigButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 58.dp, start = 36.dp, end = 36.dp)
                        .height(60.dp),
                    text = "Регистрироваться",
                    onClick = {
                        val phone = phoneState
                        val password = passwordState
                        viewModel.register(phone, password)
                        // TOOD
                        navController.navigate(Graph.HomeGraph.route)
                    }
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    if (stateRegistration.isLoading) {
                        CircularProgressIndicator()
                    }

                    if (stateRegistration.error != "") {
                        Text(text = "Accured some error ${stateRegistration.error}")
                    }

                    /*Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        CustomGrayText(
                            modifier = Modifier.padding(end = 6.dp),
                            text = "Не зарегистрированы?"
                        )
                        CustomUnderlinedText(text = "Регистрация", onClick = {
                            navController.navigate(Screen.RegistrationScreen.route)
                        })
                    }*/
                }
            }
        }
    }
}