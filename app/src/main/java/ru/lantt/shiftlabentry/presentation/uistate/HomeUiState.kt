package ru.lantt.shiftlabentry.presentation.uistate

sealed interface HomeUiState {

    object Loading : HomeUiState

    object Content : HomeUiState

}