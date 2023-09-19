package ru.lantt.shiftlabentry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.lantt.shiftlabentry.presentation.ui.theme.ShiftLabEntryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShiftLabEntryTheme {

            }
        }
    }
}