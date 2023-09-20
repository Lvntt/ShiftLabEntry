package ru.lantt.shiftlabentry.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.lantt.shiftlabentry.presentation.ui.screen.home.HomeScreen
import ru.lantt.shiftlabentry.presentation.ui.screen.registration.RegistrationScreen

object ShiftLabEntryDestinations {
    const val REGISTRATION = "registration"
    const val HOME = "home"
}

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ShiftLabEntryDestinations.REGISTRATION
    ) {
        composable(ShiftLabEntryDestinations.REGISTRATION) {
            RegistrationScreen(navController = navController)
        }
        composable(ShiftLabEntryDestinations.HOME) {
            HomeScreen()
        }
    }
}