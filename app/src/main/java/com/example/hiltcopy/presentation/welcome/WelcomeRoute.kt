package com.example.hiltcopy.presentation.welcome

sealed class WelcomeRoute (

    val name:String

) {

    object WelcomeScreen : WelcomeRoute("WelcomeScreen")

    object LoginScreen : WelcomeRoute("LoginScreen")

}