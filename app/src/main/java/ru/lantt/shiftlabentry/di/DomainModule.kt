package ru.lantt.shiftlabentry.di

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.lantt.shiftlabentry.data.datasource.UserDataSource
import ru.lantt.shiftlabentry.data.repository.UserRepositoryImpl
import ru.lantt.shiftlabentry.domain.repository.UserRepository
import ru.lantt.shiftlabentry.domain.usecase.GetUserUseCase
import ru.lantt.shiftlabentry.domain.usecase.SaveUserUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateDateOfBirthUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateFirstNameUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidatePasswordUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateRepeatedPasswordUseCase
import ru.lantt.shiftlabentry.domain.usecase.ValidateSecondNameUseCase

private fun provideUserRepository(
    userDataSource: UserDataSource
): UserRepository = UserRepositoryImpl(userDataSource)

fun provideDomainModule(): Module = module {

    single {
        provideUserRepository(get())
    }

    factory {
        GetUserUseCase(get())
    }

    factory {
        SaveUserUseCase(get())
    }

    factory {
        ValidateFirstNameUseCase()
    }

    factory {
        ValidateSecondNameUseCase()
    }

    factory {
        ValidateDateOfBirthUseCase()
    }

    factory {
        ValidatePasswordUseCase()
    }

    factory {
        ValidateRepeatedPasswordUseCase()
    }

}