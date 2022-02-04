package com.example.vocansies.core.entity.internal

sealed class Graph(val route: String) {
    object ProfileGraph : Graph("ProfileGraph")
    object HomeGraph : Graph("HomeGraph")
    object AuthGraph : Graph("AuthGraph")
    object ResumeGraph : Graph("ResumeGraph")
    object AddVacancyGraph : Graph("AddVacancyGraph")
    object MyFavoriteVacanciesGraph : Graph("MyFavoriteVacanciesGraph")
    //object OrdersGraph : Graph("OrdersGraph")
}