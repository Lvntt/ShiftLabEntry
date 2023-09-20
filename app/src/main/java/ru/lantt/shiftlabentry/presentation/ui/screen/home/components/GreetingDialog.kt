package ru.lantt.shiftlabentry.presentation.ui.screen.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import ru.lantt.shiftlabentry.R
import ru.lantt.shiftlabentry.presentation.ui.theme.ButtonTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.ImageRegularSize
import ru.lantt.shiftlabentry.presentation.ui.theme.Orange
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingExtraSmall
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingMedium
import ru.lantt.shiftlabentry.presentation.ui.theme.RoundedCornerShapePercentMedium
import ru.lantt.shiftlabentry.presentation.ui.theme.SmallElevation
import ru.lantt.shiftlabentry.presentation.ui.theme.Subtitle
import ru.lantt.shiftlabentry.presentation.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingDialog(
    viewModel: HomeViewModel,
    onDismiss: () -> Unit
) {
    AlertDialog(onDismissRequest = onDismiss) {
        GreetingDialogUI(
            viewModel = viewModel,
            onDismiss = onDismiss
        )
    }
}

@Composable
private fun GreetingDialogUI(
    viewModel: HomeViewModel,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val fullName = viewModel.getFullUserName()

    Card(
        shape = RoundedCornerShape(RoundedCornerShapePercentMedium),
        modifier = Modifier.padding(PaddingExtraSmall),
        elevation = CardDefaults.cardElevation(defaultElevation = SmallElevation)
    ) {
        Column(
            modifier = modifier.background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.sun_image),
                contentScale = ContentScale.Fit,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = PaddingMedium)
                    .size(ImageRegularSize)
            )
            Column(modifier = Modifier.padding(PaddingMedium)) {
                Text(
                    text = if (fullName == null) stringResource(id = R.string.noUser)
                            else stringResource(id = R.string.greeting) + " $fullName!",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = ButtonTextStyle,
                    maxLines = 2
                )
            }
            TextButton(
                onClick = onDismiss,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Orange)
            ) {
                Text(
                    text = stringResource(id = R.string.hiThere),
                    textAlign = TextAlign.Center,
                    style = Subtitle,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}