package ru.lantt.shiftlabentry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import ru.lantt.shiftlabentry.presentation.ui.navigation.Navigation
import ru.lantt.shiftlabentry.presentation.ui.theme.ShiftLabEntryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShiftLabEntryTheme {
                val navController = rememberNavController()

                Navigation(navController = navController)
            }
        }
    }
}