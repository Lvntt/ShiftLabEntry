package ru.lantt.shiftlabentry.presentation.ui.screen.registration.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import ru.lantt.shiftlabentry.common.Constants
import ru.lantt.shiftlabentry.presentation.ui.theme.ContainerColor
import ru.lantt.shiftlabentry.presentation.ui.theme.ErrorTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingExtraSmall
import ru.lantt.shiftlabentry.presentation.ui.theme.PlaceholderTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.RegularTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.RoundedCornerShapePercentMedium
import ru.lantt.shiftlabentry.presentation.ui.theme.TextFieldIconSize

@Composable
fun FormTextField(
    label: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    textFieldValue: String = Constants.EMPTY_STRING,
    onValueChange: (String) -> Unit,
    hasError: Boolean = false,
    errorId: Int? = null
) {
    Column {
        Row(modifier = modifier.fillMaxWidth()) {
            TextField(
                value = textFieldValue,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        text = label,
                        style = PlaceholderTextStyle
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(TextFieldIconSize)
                    )
                },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = ContainerColor,
                    errorContainerColor = ContainerColor,
                    focusedContainerColor = ContainerColor,
                    unfocusedContainerColor = ContainerColor,
                    focusedTextColor = Color.DarkGray,
                    unfocusedTextColor = Color.DarkGray,
                    disabledTextColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledPlaceholderColor = Color.DarkGray,
                    disabledTrailingIconColor = Color.DarkGray
                ),
                textStyle = RegularTextStyle,
                shape = RoundedCornerShape(percent = RoundedCornerShapePercentMedium),
                modifier = modifier.fillMaxWidth(),
                singleLine = true
            )
        }
        Text(
            text = if (hasError) stringResource(id = errorId!!) else "",
            color = MaterialTheme.colorScheme.error,
            style = ErrorTextStyle,
            modifier = Modifier.padding(start = PaddingExtraSmall)
        )
    }
}