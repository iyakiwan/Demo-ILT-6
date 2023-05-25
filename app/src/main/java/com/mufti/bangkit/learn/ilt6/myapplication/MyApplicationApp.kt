package com.mufti.bangkit.learn.ilt6.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mufti.bangkit.learn.ilt6.myapplication.model.HeroesData
import com.mufti.bangkit.learn.ilt6.myapplication.ui.navigation.BottomBar
import com.mufti.bangkit.learn.ilt6.myapplication.ui.navigation.Screen
import com.mufti.bangkit.learn.ilt6.myapplication.ui.screen.about.AboutScreen
import com.mufti.bangkit.learn.ilt6.myapplication.ui.screen.home.HomeScreen
import com.mufti.bangkit.learn.ilt6.myapplication.ui.theme.MyApplicationTheme

@Composable
fun MyApplicationApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailHeroes.route) {
                BottomBar(
                    navController = navController
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    listHero = HeroesData.heroes,
                    navigateToDetail = { username ->
                        navController.navigate(Screen.DetailHeroes.createRoute(username))
                    },
                )
            }
            composable(Screen.About.route) {
                AboutScreen()
            }
            composable(
                route = Screen.DetailHeroes.route,
                arguments = listOf(navArgument("id") { type = NavType.StringType }),
            ) {
                val username = it.arguments?.getString("id") ?: ""
                /*DetailScreen(
                    username = username,
                    viewModel = viewModel(
                        factory = ViewModelFactory.getInstance(context)
                    ),
                    navigateBack = {
                        navController.navigateUp()
                    },
                )*/
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        MyApplicationApp()
    }
}