package ru.lantt.shiftlabentry.domain.entity

data class User(
    val firstName: String,
    val secondName: String,
    val dateOfBirthMillis: Long,
    val password: String
)
