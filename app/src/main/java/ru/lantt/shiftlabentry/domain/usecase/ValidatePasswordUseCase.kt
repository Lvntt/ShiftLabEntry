package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.entity.ErrorType
import ru.lantt.shiftlabentry.domain.entity.ValidationResult
import ru.lantt.shiftlabentry.domain.util.Constants

class ValidatePasswordUseCase {

    operator fun invoke(password: String?): ValidationResult {
        if (password == null) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.EMPTY_FIELD
            )
        }

        if (!password.any { it.isDigit() } || !password.any { it.isLetter() }) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.NO_DIGITS_OR_LETTERS
            )
        }
        if (password.length < Constants.PASSWORD_MIN_SYMBOLS) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.INVALID_PASSWORD_LENGTH
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }

}