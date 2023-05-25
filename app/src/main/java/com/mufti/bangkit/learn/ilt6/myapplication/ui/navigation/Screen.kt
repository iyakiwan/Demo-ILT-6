package com.mufti.bangkit.learn.ilt6.myapplication.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object About : Screen("about")
    object DetailHeroes : Screen("home/{id}") {
        fun createRoute(id: String) = "home/$id"
    }
}
