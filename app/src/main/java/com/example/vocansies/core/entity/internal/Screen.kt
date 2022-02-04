package com.example.vocansies.core.entity.internal

sealed class Screen(val route:String) {

    object LoginScreen:Screen("LoginScreen")
    object RegistrationScreen:Screen("RegistrationScreen")
    object HomeScreen:Screen("HomeScreen")
    object DescriptionScreen:Screen("DescriptionScreen")
    object ProfileScreen:Screen("ProfileScreen")
    object AboutAppScreen:Screen("AboutAppScreen")
    object SuitableJobScreen:Screen("SuitableJobScreen")
    object InterviewScreen:Screen("InterviewScreen")
    object AddVacancyScreen:Screen("AddVacancyScreen")
    object ResumeScreen:Screen("ResumeScreen")
    object MyFavoriteVacanciesScreen:Screen("MyFavoriteVacanciesScreen")
    object ArticleDescriptionScreen:Screen("ArticleDescriptionScreen")
}