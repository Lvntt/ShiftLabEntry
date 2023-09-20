package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.entity.ErrorType
import ru.lantt.shiftlabentry.domain.entity.ValidationResult
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

class ValidateDateOfBirthUseCase {

    operator fun invoke(dateOfBirthMillis: Long): ValidationResult {
        val dobLocalDate = Date(dateOfBirthMillis).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        val minValidDate = LocalDate.now().minusYears(120)

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