package ru.lantt.shiftlabentry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.lantt.shiftlabentry.presentation.ui.navigation.Navigation
import ru.lantt.shiftlabentry.presentation.ui.theme.ShiftLabEntryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShiftLabEntryTheme {
                val uiController = rememberSystemUiController()
                val navController = rememberNavController()

                uiController.setSystemBarsColor(MaterialTheme.colorScheme.background)

                Navigation(navController = navController)
            }
        }
    }
}