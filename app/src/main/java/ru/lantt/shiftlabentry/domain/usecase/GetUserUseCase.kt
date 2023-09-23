package ru.lantt.shiftlabentry.domain.usecase

import ru.lantt.shiftlabentry.domain.entity.User
import ru.lantt.shiftlabentry.domain.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): User? = userRepository.getUser()

}