package ru.lantt.shiftlabentry.presentation.event

sealed interface LoginEvent {

    object RegistrationRequired : LoginEvent

}