package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.entity.ErrorType
import ru.lantt.shiftlabentry.domain.entity.ValidationResult

class ValidateRepeatedPasswordUseCase {

    operator fun invoke(password: String?, repeatedPassword: String?): ValidationResult {
        if (password == null || repeatedPassword == null) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.EMPTY_FIELD
            )
        }

        if (password != repeatedPassword) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.PASSWORDS_MISMATCH
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }

}