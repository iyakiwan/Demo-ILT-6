package com.mufti.bangkit.learn.ilt6.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mufti.bangkit.learn.ilt6.myapplication.ui.navigation.BottomBar
import com.mufti.bangkit.learn.ilt6.myapplication.ui.navigation.Screen
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
                /*HomeScreen(
                    viewModel = viewModel(
                        factory = ViewModelFactory.getInstance(context)
                    ),
                    navigateToDetail = { username ->
                        navController.navigate(Screen.DetailUser.createRoute(username))
                    },
                    onShowToast = { message ->
                        showToast(context, message)
                    }
                )*/
            }
            composable(Screen.About.route) {
//                AboutScreen()
            }
            composable(
                route = Screen.DetailHeroes.route,
                arguments = listOf(navArgument("id") { type = NavType.StringType }),
            ) {
                val context = LocalContext.current
                val username = it.arguments?.getString("id") ?: ""
                /*DetailScreen(
                    username = username,
                    viewModel = viewModel(
                        factory = ViewModelFactory.getInstance(context)
                    ),
                    navigateBack = {
                        navController.navigateUp()
                    },
                    onShowToast = { message ->
                        showToast(context, message)
                    }
                )*/
            }
        }
    }
    /*Box(modifier = modifier) {
        LazyColumn {
            items(HeroesData.heroes, key = { it.id }) { hero ->
                HeroItem(
                    hero = hero,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }*/
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        MyApplicationApp()
    }
}