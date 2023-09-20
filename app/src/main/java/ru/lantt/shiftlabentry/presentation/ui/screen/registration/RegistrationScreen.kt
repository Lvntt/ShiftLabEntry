package ru.lantt.shiftlabentry.presentation.ui.screen.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.lantt.shiftlabentry.R
import ru.lantt.shiftlabentry.presentation.ui.navigation.ShiftLabEntryDestinations
import ru.lantt.shiftlabentry.presentation.ui.screen.registration.components.DatePickerField
import ru.lantt.shiftlabentry.presentation.ui.screen.registration.components.FormTextField
import ru.lantt.shiftlabentry.presentation.ui.screen.registration.components.GreetingsSubtitleText
import ru.lantt.shiftlabentry.presentation.ui.screen.registration.components.GreetingsTitleText
import ru.lantt.shiftlabentry.presentation.ui.screen.registration.components.PasswordTextField
import ru.lantt.shiftlabentry.presentation.ui.screen.registration.components.RegisterButton
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingExtraLarge
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingLarge
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingMedium
import ru.lantt.shiftlabentry.presentation.viewmodel.RegistrationViewModel

@Composable
fun RegistrationScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: RegistrationViewModel = koinViewModel()
) {
    val registrationState by remember { viewModel.registrationUiState }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(PaddingLarge)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.padding(PaddingLarge))

        GreetingsTitleText(modifier = Modifier.align(Alignment.CenterHorizontally))
        GreetingsSubtitleText(modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.padding(PaddingLarge))

        FormTextField(
            label = stringResource(id = R.string.first_name_placeholder),
            icon = ImageVector.vectorResource(id = R.drawable.person_icon),
            textFieldValue = registrationState.firstName,
            onValueChange = viewModel::setFirstName,
            hasError = registrationState.firstNameErrorId != null,
            errorId = registrationState.firstNameErrorId
        )

        Spacer(modifier = Modifier.height(PaddingMedium))

        FormTextField(
            label = stringResource(id = R.string.second_name_placeholder),
            icon = ImageVector.vectorResource(id = R.drawable.person_icon),
            textFieldValue = registrationState.secondName,
            onValueChange = viewModel::setSecondName,
            hasError = registrationState.secondNameErrorId != null,
            errorId = registrationState.secondNameErrorId
        )

        Spacer(modifier = Modifier.height(PaddingMedium))

        DatePickerField(
            textFieldValue = viewModel.getFormattedDate() ?: "",
            onDatePick = viewModel::setDateOfBirth,
            hasError = registrationState.dateOfBirthErrorId != null,
            errorId = registrationState.dateOfBirthErrorId
        )

        Spacer(modifier = Modifier.height(PaddingMedium))

        PasswordTextField(
            label = stringResource(id = R.string.password_placeholder),
            textFieldValue = registrationState.password,
            onValueChange = viewModel::setPassword,
            hasError = registrationState.passwordErrorId != null,
            errorId = registrationState.passwordErrorId
        )

        Spacer(modifier = Modifier.height(PaddingMedium))

        PasswordTextField(
            label = stringResource(id = R.string.repeat_password_placeholder),
            textFieldValue = registrationState.repeatedPassword,
            onValueChange = viewModel::setRepeatedPassword,
            hasError = registrationState.repeatedPasswordErrorId != null,
            errorId = registrationState.repeatedPasswordErrorId
        )

        Spacer(modifier = Modifier.height(PaddingExtraLarge))
        
        RegisterButton(
            onClick = {
                viewModel.onRegister()
                navController.navigate(ShiftLabEntryDestinations.HOME)
            },
            isEnabled = viewModel.registrationIsAllowed()
        )
    }
}