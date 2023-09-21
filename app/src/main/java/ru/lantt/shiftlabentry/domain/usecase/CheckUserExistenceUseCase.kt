package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.repository.UserRepository

class CheckUserExistenceUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): Boolean {
        return userRepository.getUser()?.firstName != null
    }

}