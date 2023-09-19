package ru.lantt.shiftlabentry.presentation.screen.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import ru.lantt.shiftlabentry.R
import ru.lantt.shiftlabentry.presentation.screen.registration.components.FormTextField
import ru.lantt.shiftlabentry.presentation.screen.registration.components.GreetingsSubtitleText
import ru.lantt.shiftlabentry.presentation.screen.registration.components.GreetingsTitleText
import ru.lantt.shiftlabentry.presentation.screen.registration.components.RegisterButton
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingExtraLarge
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingLarge
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingMedium

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(PaddingLarge)
    ) {
        Spacer(modifier = Modifier.padding(PaddingLarge))

        GreetingsTitleText(modifier = Modifier.align(Alignment.CenterHorizontally))
        GreetingsSubtitleText(modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.padding(PaddingLarge))

        FormTextField(
            label = stringResource(id = R.string.first_name_placeholder),
            icon = ImageVector.vectorResource(id = R.drawable.person_icon),
            onValueChange = {}
        )

        Spacer(modifier = Modifier.height(PaddingMedium))

        FormTextField(
            label = stringResource(id = R.string.second_name_placeholder),
            icon = ImageVector.vectorResource(id = R.drawable.person_icon),
            onValueChange = {}
        )

        Spacer(modifier = Modifier.height(PaddingMedium))

        FormTextField(
            label = stringResource(id = R.string.date_of_birth_placeholder),
            icon = ImageVector.vectorResource(id = R.drawable.date_icon),
            onValueChange = {}
        )

        Spacer(modifier = Modifier.height(PaddingMedium))

        FormTextField(
            label = stringResource(id = R.string.password_placeholder),
            icon = ImageVector.vectorResource(id = R.drawable.password_icon),
            onValueChange = {}
        )

        Spacer(modifier = Modifier.height(PaddingMedium))

        FormTextField(
            label = stringResource(id = R.string.repeat_password_placeholder),
            icon = ImageVector.vectorResource(id = R.drawable.password_icon),
            onValueChange = {}
        )

        Spacer(modifier = Modifier.height(PaddingExtraLarge))
        
        RegisterButton(onClick = {})
    }
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationScreen()
}