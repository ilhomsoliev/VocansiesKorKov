package com.example.vocansies.core.entity.internal

sealed class Screen(val route:String) {

    object LoginScreen:Screen("LoginScreen")
    object RegistrationScreen:Screen("RegistrationScreen")
    object HomeScreen:Screen("HomeScreen")
    object DescriptionScreen:Screen("DescriptionScreen")
    object ProfileScreen:Screen("ProfileScreen")
}