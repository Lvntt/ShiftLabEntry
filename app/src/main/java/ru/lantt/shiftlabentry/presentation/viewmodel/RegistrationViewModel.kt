package ru.lantt.shiftlabentry.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ru.lantt.shiftlabentry.common.Constants
import ru.lantt.shiftlabentry.domain.entity.ErrorType
import ru.lantt.shiftlabentry.domain.entity.User
import ru.lantt.shiftlabentry.domain.usecase.SaveUserUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateDateOfBirthUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateFirstNameUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidatePasswordUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateRepeatedPasswordUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateSecondNameUseCase
import ru.lantt.shiftlabentry.presentation.mapper.ErrorTypeToStringRes
import ru.lantt.shiftlabentry.presentation.uistate.RegistrationState
import java.text.SimpleDateFormat
import java.util.Locale

class RegistrationViewModel(
    private val validateFirstNameUseCase: ValidateFirstNameUseCase,
    private val validateSecondNameUseCase: ValidateSecondNameUseCase,
    private val validateDateOfBirthUseCase: ValidateDateOfBirthUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val validateRepeatedPasswordUseCase: ValidateRepeatedPasswordUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    val registrationState: State<RegistrationState>
        get() = _registrationState
    private val _registrationState = mutableStateOf(RegistrationState())

    private fun getErrorDescription(errorType: ErrorType?): Int? {
        if (errorType == null) {
            return null
        }
        return ErrorTypeToStringRes.errors[errorType]
    }

    private fun validateFirstName() {
        val validationResult = validateFirstNameUseCase(_registrationState.value.firstName)
        val errorDescription = getErrorDescription(validationResult.errorType)
        _registrationState.value = _registrationState.value.copy(firstNameErrorId = errorDescription)
    }

    private fun validateSecondName() {
        val validationResult = validateSecondNameUseCase(_registrationState.value.secondName)
        val errorDescription = getErrorDescription(validationResult.errorType)
        _registrationState.value = _registrationState.value.copy(secondNameErrorId = errorDescription)
    }

    private fun validatePassword() {
        val validationResult = validatePasswordUseCase(_registrationState.value.password)
        val errorDescription = getErrorDescription(validationResult.errorType)
        _registrationState.value = _registrationState.value.copy(passwordErrorId = errorDescription)
    }

    private fun validateRepeatedPassword() {
        val validationResult = validateRepeatedPasswordUseCase(
            _registrationState.value.password,
            _registrationState.value.repeatedPassword
        )
        val errorDescription = getErrorDescription(validationResult.errorType)
        _registrationState.value = _registrationState.value.copy(repeatedPasswordErrorId = errorDescription)
    }

    private fun validateDateOfBirth() {
        val validationResult = validateDateOfBirthUseCase(_registrationState.value.dateOfBirth)
        val errorDescription = getErrorDescription(validationResult.errorType)
        _registrationState.value = _registrationState.value.copy(dateOfBirthErrorId = errorDescription)
    }

    fun setFirstName(firstName: String) {
        _registrationState.value = _registrationState.value.copy(firstName = firstName)
        validateFirstName()
    }

    fun setSecondName(secondName: String) {
        _registrationState.value = _registrationState.value.copy(secondName = secondName)
        validateSecondName()
    }

    fun setDateOfBirth(dateOfBirthMillis: Long) {
        _registrationState.value = _registrationState.value.copy(dateOfBirth = dateOfBirthMillis)
        validateDateOfBirth()
    }

    fun setPassword(password: String) {
        _registrationState.value = _registrationState.value.copy(password = password)
        validatePassword()
        validateRepeatedPassword()
    }

    fun setRepeatedPassword(repeatedPassword: String) {
        _registrationState.value = _registrationState.value.copy(repeatedPassword = repeatedPassword)
        validateRepeatedPassword()
    }

    fun getFormattedDate(): String? {
        val dateOfBirth = _registrationState.value.dateOfBirth ?: return null

        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return simpleDateFormat.format(dateOfBirth)
    }

    fun registrationIsAllowed(): Boolean {
        val registrationState = _registrationState.value
        return registrationState.firstName.isNotEmpty()
                && registrationState.secondName.isNotEmpty()
                && registrationState.dateOfBirth != null
                && registrationState.password.isNotEmpty()
                && registrationState.repeatedPassword.isNotEmpty()
                && registrationState.firstNameErrorId == null
                && registrationState.secondNameErrorId == null
                && registrationState.dateOfBirthErrorId == null
                && registrationState.passwordErrorId == null
                && registrationState.repeatedPasswordErrorId == null
    }

    fun onRegister() {
        val registrationState = _registrationState.value

        saveUserUseCase(
            User(
                firstName = registrationState.firstName.replaceFirstChar { it.uppercaseChar() },
                secondName = registrationState.secondName.replaceFirstChar { it.uppercaseChar() },
                dateOfBirthMillis = registrationState.dateOfBirth ?: Constants.DATE_OF_BIRTH_ERROR_CODE,
                password = registrationState.password
            )
        )
    }

}