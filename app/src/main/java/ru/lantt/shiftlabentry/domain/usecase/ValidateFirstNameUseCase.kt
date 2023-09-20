package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.entity.ErrorType
import ru.lantt.shiftlabentry.domain.entity.ValidationResult

class ValidateFirstNameUseCase {

    operator fun invoke(firstName: String): ValidationResult {
        if (firstName.length < 2) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.INVALID_FIRST_NAME_LENGTH
            )
        }
        if (firstName.contains("[^A-Za-z]+")) {
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