package ru.lantt.shiftlabentry.presentation.viewmodel

import androidx.lifecycle.ViewModel
import ru.lantt.shiftlabentry.domain.entity.User
import ru.lantt.shiftlabentry.domain.usecase.GetUserUseCase

class HomeViewModel(
    getUserUseCase: GetUserUseCase
) : ViewModel() {

    private var user: User? = null

    init {
        user = getUserUseCase()
    }

    fun getFullUserName(): String? {
        if (user == null) {
            return null
        }
        return "${user?.firstName} ${user?.secondName}"
    }

}