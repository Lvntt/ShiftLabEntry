package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.entity.ErrorType
import ru.lantt.shiftlabentry.domain.entity.ValidationResult

class ValidateSecondNameUseCase {

    operator fun invoke(secondName: String): ValidationResult {
        if (secondName.length < 2) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.INVALID_SECOND_NAME_LENGTH
            )
        }
        if (secondName.contains("[^A-Za-z]+")) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.INVALID_SECOND_NAME_VALUE
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }

}