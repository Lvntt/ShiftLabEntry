package ru.lantt.shiftlabentry.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ru.lantt.shiftlabentry.domain.entity.ErrorType
import ru.lantt.shiftlabentry.domain.usecase.ValidateDateOfBirthUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateFirstNameUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidatePasswordUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateRepeatedPasswordUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateSecondNameUseCase
import ru.lantt.shiftlabentry.presentation.mapper.ErrorTypeToStringRes
import ru.lantt.shiftlabentry.presentation.uistate.RegistrationUiState
import java.text.SimpleDateFormat

class RegistrationViewModel(
    private val validateFirstNameUseCase: ValidateFirstNameUseCase,
    private val validateSecondNameUseCase: ValidateSecondNameUseCase,
    private val validateDateOfBirthUseCase: ValidateDateOfBirthUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val validateRepeatedPasswordUseCase: ValidateRepeatedPasswordUseCase
) : ViewModel() {

    val registrationUiState: State<RegistrationUiState>
        get() = _registrationUiState
    private val _registrationUiState = mutableStateOf(RegistrationUiState())

    private fun getErrorDescription(errorType: ErrorType?): Int? {
        if (errorType == null) {
            return null
        }
        return ErrorTypeToStringRes.errors[errorType]
    }

    private fun validateFirstName(): Boolean {
        val validationResult = validateFirstNameUseCase(_registrationUiState.value.firstName)
        val errorDescription = getErrorDescription(validationResult.errorType)
        _registrationUiState.value = _registrationUiState.value.copy(firstNameErrorId = errorDescription)

        return validationResult.isSuccessful
    }

    private fun validateSecondName(): Boolean {
        val validationResult = validateSecondNameUseCase(_registrationUiState.value.secondName)
        val errorDescription = getErrorDescription(validationResult.errorType)
        _registrationUiState.value = _registrationUiState.value.copy(secondNameErrorId = errorDescription)

        return validationResult.isSuccessful
    }

    private fun validatePassword(): Boolean {
        val validationResult = validatePasswordUseCase(_registrationUiState.value.password)
        val errorDescription = getErrorDescription(validationResult.errorType)
        _registrationUiState.value = _registrationUiState.value.copy(passwordErrorId = errorDescription)

        return validationResult.isSuccessful
    }

    private fun validateRepeatedPassword(): Boolean {
        val validationResult = validateRepeatedPasswordUseCase(
            _registrationUiState.value.password,
            _registrationUiState.value.repeatedPassword
        )
        val errorDescription = getErrorDescription(validationResult.errorType)
        _registrationUiState.value = _registrationUiState.value.copy(repeatedPasswordErrorId = errorDescription)

        return validationResult.isSuccessful
    }

    private fun validateDateOfBirth(): Boolean {
        val validationResult = validateDateOfBirthUseCase(_registrationUiState.value.dateOfBirth)
        val errorDescription = getErrorDescription(validationResult.errorType)
        _registrationUiState.value = _registrationUiState.value.copy(dateOfBirthErrorId = errorDescription)

        return validationResult.isSuccessful
    }

    fun setFirstName(firstName: String) {
        _registrationUiState.value = _registrationUiState.value.copy(firstName = firstName)
        validateFirstName()
    }

    fun setSecondName(secondName: String) {
        _registrationUiState.value = _registrationUiState.value.copy(secondName = secondName)
        validateSecondName()
    }

    fun setDateOfBirth(dateOfBirthMillis: Long) {
        _registrationUiState.value = _registrationUiState.value.copy(dateOfBirth = dateOfBirthMillis)
        validateDateOfBirth()
    }

    fun setPassword(password: String) {
        _registrationUiState.value = _registrationUiState.value.copy(password = password)
        validatePassword()
        validateRepeatedPassword()
    }

    fun setRepeatedPassword(repeatedPassword: String) {
        _registrationUiState.value = _registrationUiState.value.copy(repeatedPassword = repeatedPassword)
        validateRepeatedPassword()
    }

    fun getFormattedDate(): String? {
        val dateOfBirth = _registrationUiState.value.dateOfBirth ?: return null

        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
        return simpleDateFormat.format(dateOfBirth)
    }

    fun registrationIsAllowed(): Boolean {
        val registrationState = _registrationUiState.value
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

}