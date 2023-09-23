package ru.lantt.shiftlabentry.domain.entity

data class ValidationResult(
    val isSuccessful: Boolean,
    val errorType: ErrorType? = null
)
