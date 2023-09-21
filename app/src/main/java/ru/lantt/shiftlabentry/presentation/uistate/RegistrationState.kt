package ru.lantt.shiftlabentry.presentation.uistate

import ru.lantt.shiftlabentry.common.Constants

data class RegistrationState(
    val firstName: String = Constants.EMPTY_STRING,
    val firstNameErrorId: Int? = null,
    val secondName: String = Constants.EMPTY_STRING,
    val secondNameErrorId: Int? = null,
    val dateOfBirth: Long? = null,
    val dateOfBirthErrorId: Int? = null,
    val password: String = Constants.EMPTY_STRING,
    val passwordErrorId: Int? = null,
    val repeatedPassword: String = Constants.EMPTY_STRING,
    val repeatedPasswordErrorId: Int? = null
)
