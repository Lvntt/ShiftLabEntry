package ru.lantt.shiftlabentry.presentation.screen.registration.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import ru.lantt.shiftlabentry.R
import ru.lantt.shiftlabentry.presentation.ui.theme.ButtonContainerColor
import ru.lantt.shiftlabentry.presentation.ui.theme.ButtonContentColor
import ru.lantt.shiftlabentry.presentation.ui.theme.ButtonMinHeight
import ru.lantt.shiftlabentry.presentation.ui.theme.ButtonTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.RoundedCornerShapePercentMedium
import ru.lantt.shiftlabentry.presentation.ui.theme.TextFieldIconSize

@Composable
fun RegisterButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(RoundedCornerShapePercentMedium),
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonContainerColor,
            contentColor = ButtonContentColor
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = ButtonMinHeight)
    ) {
        Text(
            text = stringResource(id = R.string.register),
            style = ButtonTextStyle
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.keyboard_arrow_right_icon),
            contentDescription = null,
            modifier = Modifier.size(TextFieldIconSize)
        )
    }
}