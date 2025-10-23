package cl.duoc.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.duoc.app.ui.screen.HomeScreen
import cl.duoc.app.ui.screen.LoginScreen

object Routes {
    const val Login = "login"
    const val Home = "home"
}

@Composable
fun AppNav() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = Routes.Login) {
        composable(Routes.Login) {
            LoginScreen(
                onAuthenticated = {
                    nav.navigate(Routes.Home) {
                        popUpTo(Routes.Login) { inclusive = true } // elimina login del back stack
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(Routes.Home) {
            HomeScreen()
        }
    }
}
