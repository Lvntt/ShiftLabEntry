package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.entity.User
import ru.lantt.shiftlabentry.domain.repository.UserRepository

class SaveUserUseCase(private val userRepository: UserRepository) {

    operator fun invoke(user: User) = userRepository.saveUser(user)

}