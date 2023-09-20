package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.entity.ErrorType
import ru.lantt.shiftlabentry.domain.entity.ValidationResult
import ru.lantt.shiftlabentry.domain.util.Constants
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

class ValidateDateOfBirthUseCase {

    operator fun invoke(dateOfBirthMillis: Long?): ValidationResult {
        if (dateOfBirthMillis == null) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.EMPTY_FIELD
            )
        }

        val dobLocalDate = Date(dateOfBirthMillis).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        val minValidDate = LocalDate.now().minusYears(Constants.MAX_AGE_IN_YEARS.toLong())

        if (dobLocalDate.isBefore(minValidDate)) {
            return ValidationResult(
                isSuccessful = false,
                errorType = ErrorType.INVALID_DATE_OF_BIRTH
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }

}