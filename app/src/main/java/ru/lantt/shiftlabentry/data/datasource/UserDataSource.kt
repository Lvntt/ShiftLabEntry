package ru.lantt.shiftlabentry.data.datasource

import ru.lantt.shiftlabentry.domain.entity.User

interface UserDataSource {

    fun saveUser(user: User)

    fun getUser(): User?

}