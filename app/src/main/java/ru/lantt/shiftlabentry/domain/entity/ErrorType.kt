package ru.lantt.shiftlabentry.domain.entity

enum class ErrorType {
    INVALID_FIRST_NAME_LENGTH,
    INVALID_FIRST_NAME_VALUE,
    INVALID_SECOND_NAME_LENGTH,
    INVALID_SECOND_NAME_VALUE,
    INVALID_DATE_OF_BIRTH,
    NO_DIGITS_OR_LETTERS,
    INVALID_PASSWORD_LENGTH,
    PASSWORDS_MISMATCH
}