package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.entity.ErrorType
import ru.lantt.shiftlabentry.domain.entity.ValidationResult
import ru.lantt.shiftlabentry.domain.util.Constants

class ValidateFirstNameUseCase {

    operator fun invoke(firstName: String?): ValidationResult {
        if (firstName == null) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.EMPTY_FIELD
            )
        }

        if (firstName.length < Constants.FIRST_NAME_MIN_SYMBOLS) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.INVALID_FIRST_NAME_LENGTH
            )
        }
        if (firstName.any { !it.isLetter() }) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.INVALID_FIRST_NAME_VALUE
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }

}