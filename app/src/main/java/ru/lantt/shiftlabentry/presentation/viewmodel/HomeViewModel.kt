package ru.lantt.shiftlabentry.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.lantt.shiftlabentry.domain.entity.User
import ru.lantt.shiftlabentry.domain.usecase.CheckUserExistenceUseCase
import ru.lantt.shiftlabentry.domain.usecase.GetUserUseCase
import ru.lantt.shiftlabentry.presentation.uistate.HomeUiState
import ru.lantt.shiftlabentry.presentation.event.LoginEvent

class HomeViewModel(
    private val checkUserExistenceUseCase: CheckUserExistenceUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private var user: User? = null

    val homeUiState: State<HomeUiState>
        get() = _homeUiState
    private val _homeUiState: MutableState<HomeUiState> = mutableStateOf(HomeUiState.Loading)

    private val loginEventChannel = Channel<LoginEvent>()
    val loginState = loginEventChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            _homeUiState.value = HomeUiState.Loading

            if (checkUserExistenceUseCase()) {
                user = getUserUseCase()
                _homeUiState.value = HomeUiState.Content
            } else {
                loginEventChannel.send(LoginEvent.RegistrationRequired)
            }
        }
    }

    fun getFullUserName(): String? {
        if (user == null) {
            return null
        }
        return "${user?.firstName} ${user?.secondName}"
    }

}