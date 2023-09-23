package ru.lantt.shiftlabentry.presentation.ui.screen.registration.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import ru.lantt.shiftlabentry.R
import ru.lantt.shiftlabentry.common.Constants
import ru.lantt.shiftlabentry.presentation.ui.theme.ContainerColor
import ru.lantt.shiftlabentry.presentation.ui.theme.ErrorTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingExtraSmall
import ru.lantt.shiftlabentry.presentation.ui.theme.PlaceholderTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.RegularTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.RoundedCornerShapePercentMedium
import ru.lantt.shiftlabentry.presentation.ui.theme.TextFieldIconSize

@Composable
fun PasswordTextField(
    label: String,
    modifier: Modifier = Modifier,
    textFieldValue: String = Constants.EMPTY_STRING,
    onValueChange: (String) -> Unit,
    hasError: Boolean = false,
    errorId: Int? = null
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

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
                visualTransformation =
                    if (isPasswordVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon =
                        if (isPasswordVisible) ImageVector.vectorResource(id = R.drawable.visibility_off_icon)
                        else ImageVector.vectorResource(id = R.drawable.visibility_icon)
                    IconButton(
                        onClick = {
                            isPasswordVisible = !isPasswordVisible
                        },
                        modifier = Modifier.size(TextFieldIconSize)
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null
                        )
                    }
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