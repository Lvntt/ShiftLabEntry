package ru.lantt.shiftlabentry.presentation.ui.screen.registration.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
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
import ru.lantt.shiftlabentry.R
import ru.lantt.shiftlabentry.common.Constants
import ru.lantt.shiftlabentry.presentation.ui.theme.ContainerColor
import ru.lantt.shiftlabentry.presentation.ui.theme.ErrorTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.PaddingExtraSmall
import ru.lantt.shiftlabentry.presentation.ui.theme.PlaceholderTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.RegularTextStyle
import ru.lantt.shiftlabentry.presentation.ui.theme.RoundedCornerShapePercentMedium
import ru.lantt.shiftlabentry.presentation.ui.theme.TextFieldIconSize
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerField(
    modifier: Modifier = Modifier,
    textFieldValue: String = Constants.EMPTY_STRING,
    onDatePick: (Long) -> Unit,
    hasError: Boolean = false,
    errorId: Int? = null
) {
    var datePickerOpened by remember { mutableStateOf(false) }
    val currentDate = Calendar.getInstance().timeInMillis

    if (datePickerOpened) {
        val datePickerState = rememberDatePickerState()

        DatePickerDialog(
            onDismissRequest = {
                datePickerOpened = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerOpened = false
                        onDatePick(datePickerState.selectedDateMillis ?: currentDate)
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.ok)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        datePickerOpened = false
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.cancel)
                    )
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                dateValidator = {
                    it < currentDate
                }
            )
        }
    }

    Column {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            TextField(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable {
                        datePickerOpened = true
                    },
                value = textFieldValue,
                onValueChange = {},
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.date_of_birth_placeholder),
                        style = PlaceholderTextStyle
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.date_icon),
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
                    disabledTextColor = Color.DarkGray,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    disabledPlaceholderColor = Color.DarkGray,
                    disabledTrailingIconColor = Color.DarkGray
                ),
                textStyle = RegularTextStyle,
                shape = RoundedCornerShape(percent = RoundedCornerShapePercentMedium),
                singleLine = true,
                enabled = false
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