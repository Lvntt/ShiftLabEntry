package ru.lantt.shiftlabentry.presentation.ui.screen.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.koin.androidx.compose.koinViewModel
import ru.lantt.shiftlabentry.R
import ru.lantt.shiftlabentry.presentation.ui.theme.ButtonContainerColor
import ru.lantt.shiftlabentry.presentation.ui.theme.ButtonContentColor
import ru.lantt.shiftlabentry.presentation.ui.theme.ButtonMinHeight
import ru.lantt.shiftlabentry.presentation.ui.theme.ButtonTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingExtraLarge
import ru.lantt.shiftlabentry.presentation.ui.theme.RoundedCornerShapePercentMedium
import ru.lantt.shiftlabentry.presentation.viewmodel.HomeViewModel

@Composable
fun GreetingButton(
    viewModel: HomeViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    var greetingDialogOpened by remember { mutableStateOf(false) }

    if (greetingDialogOpened) {
        GreetingDialog(
            viewModel = viewModel,
            onDismiss = {
                greetingDialogOpened = false
            }
        )
    }

    Button(
        onClick = {
            greetingDialogOpened = true
        },
        shape = RoundedCornerShape(RoundedCornerShapePercentMedium),
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonContainerColor,
            contentColor = ButtonContentColor
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = ButtonMinHeight)
            .padding(horizontal = PaddingExtraLarge)
    ) {
        Text(
            text = stringResource(id = R.string.hello),
            style = ButtonTextStyle
        )
    }
}