package ru.lantt.shiftlabentry.presentation.mapper

import ru.lantt.shiftlabentry.R
import ru.lantt.shiftlabentry.domain.entity.ErrorType

object ErrorTypeToStringRes {

    val errors = mapOf(
        ErrorType.EMPTY_FIELD to R.string.empty_field_error,
        ErrorType.INVALID_FIRST_NAME_LENGTH to R.string.invalid_first_name_length_error,
        ErrorType.INVALID_FIRST_NAME_VALUE to R.string.invalid_first_name_value_error,
        ErrorType.INVALID_SECOND_NAME_LENGTH to R.string.invalid_second_name_length_error,
        ErrorType.INVALID_SECOND_NAME_VALUE to R.string.invalid_second_name_value_error,
        ErrorType.INVALID_DATE_OF_BIRTH to R.string.invalid_date_of_birth_error,
        ErrorType.NO_DIGITS_OR_LETTERS to R.string.no_digits_or_letters_error,
        ErrorType.INVALID_PASSWORD_LENGTH to R.string.invalid_password_length_error,
        ErrorType.PASSWORDS_MISMATCH to R.string.passwords_mismatch_error,
    )

}