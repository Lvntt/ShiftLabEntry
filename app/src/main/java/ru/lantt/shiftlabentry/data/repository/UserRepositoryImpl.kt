package ru.lantt.shiftlabentry.data.repository

import ru.lantt.shiftlabentry.data.datasource.UserDataSource
import ru.lantt.shiftlabentry.domain.entity.User
import ru.lantt.shiftlabentry.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {

    override fun saveUser(user: User) {
        userDataSource.saveUser(user)
    }

    override fun getUser(): User? {
        return userDataSource.getUser()
    }

}