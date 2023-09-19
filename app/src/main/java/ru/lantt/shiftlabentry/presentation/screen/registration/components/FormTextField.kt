package ru.lantt.shiftlabentry.presentation.screen.registration.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import ru.lantt.shiftlabentry.common.Constants
import ru.lantt.shiftlabentry.presentation.ui.theme.ContainerColor
import ru.lantt.shiftlabentry.presentation.ui.theme.RoundedCornerShapePercentMedium
import ru.lantt.shiftlabentry.presentation.ui.theme.TextFieldIconSize
import ru.lantt.shiftlabentry.presentation.ui.theme.PlaceholderTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.RegularTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormTextField(
    label: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    textFieldValue: String = Constants.EMPTY_STRING,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
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
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = ContainerColor,
                textColor = Color.DarkGray,
                errorBorderColor = MaterialTheme.colorScheme.error,
                disabledTextColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent
            ),
            textStyle = RegularTextStyle,
            shape = RoundedCornerShape(percent = RoundedCornerShapePercentMedium),
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = keyboardOptions,
            singleLine = true
        )
    }
}