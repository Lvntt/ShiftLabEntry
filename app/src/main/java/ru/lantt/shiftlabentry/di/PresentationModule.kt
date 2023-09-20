package ru.lantt.shiftlabentry.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.lantt.shiftlabentry.presentation.viewmodel.HomeViewModel
import ru.lantt.shiftlabentry.presentation.viewmodel.RegistrationViewModel

fun providePresentationModule(): Module = module {

    viewModel {
        RegistrationViewModel(
            get(), get(), get(), get(), get(), get()
        )
    }

    viewModel {
        HomeViewModel(
            get()
        )
    }

}