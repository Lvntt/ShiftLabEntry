package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.entity.ErrorType
import ru.lantt.shiftlabentry.domain.entity.ValidationResult
import ru.lantt.shiftlabentry.domain.util.Constants

class ValidateSecondNameUseCase {

    operator fun invoke(secondName: String?): ValidationResult {
        if (secondName == null) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.EMPTY_FIELD
            )
        }

        if (secondName.length < Constants.SECOND_NAME_MIN_SYMBOLS) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.INVALID_SECOND_NAME_LENGTH
            )
        }
        if (secondName.any { !it.isLetter() }) {
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