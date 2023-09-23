package ru.lantt.shiftlabentry.domain.repository

import ru.lantt.shiftlabentry.domain.entity.User

interface UserRepository {

    fun saveUser(user: User)

    fun getUser(): User?

}