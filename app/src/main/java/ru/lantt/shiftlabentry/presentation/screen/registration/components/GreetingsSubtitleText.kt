package ru.lantt.shiftlabentry.presentation.screen.registration.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.lantt.shiftlabentry.R
import ru.lantt.shiftlabentry.presentation.ui.theme.Subtitle

@Composable
fun GreetingsSubtitleText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.greeting_subtitle),
        style = Subtitle,
        modifier = modifier
    )
}