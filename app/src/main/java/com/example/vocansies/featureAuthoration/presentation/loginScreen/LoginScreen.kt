package com.example.vocansies.featureAuthoration.presentation.loginScreen

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
import com.example.vocansies.common_ui.components.*
import com.example.vocansies.core.entity.internal.Screen
import com.example.vocansies.core.entity.screenState.LoginResponseState

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginScreenViewModel = hiltViewModel()) {

    val phoneState by viewModel.phone
    val passwordState by viewModel.password
    val passwordVisibilityState by viewModel.passwordVisibility
    val stateLogin: LoginResponseState by viewModel.stateLogin
    val tokenState by viewModel.stateToken

    if (tokenState.tokenResponse != "") {
        navController.navigate(Screen.HomeScreen.route) {
            popUpTo(Screen.LoginScreen.route) {
                inclusive = true
            }
        }
        viewModel.makeTokenEmpty()
    }

    LoadingIndicator(isLoading = tokenState.isLoading)

    if (tokenState.tokenResponse == "" && !tokenState.isLoading) {
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, end = 36.dp)
                ) {
                    CustomGrayText(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Забыли Пароль?",
                        textAlign = TextAlign.End
                    )
                }
                CustomBigButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 58.dp, start = 36.dp, end = 36.dp)
                        .height(60.dp),
                    text = "Войти",
                    onClick = {
                        val phone = phoneState
                        val password = passwordState
                        viewModel.login(phone, password)
                    }
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    if (stateLogin.isLoading) {
                        CircularProgressIndicator()
                    }

                    if (stateLogin.error != "") {
                        Text(text = "Accured some error ${stateLogin.error}")
                    }

                    Row(
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
                    }
                }
            }
        }
    }
}