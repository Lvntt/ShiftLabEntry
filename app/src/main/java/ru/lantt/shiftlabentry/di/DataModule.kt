package ru.lantt.shiftlabentry.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.lantt.shiftlabentry.data.datasource.UserDataSource
import ru.lantt.shiftlabentry.data.datasource.UserDataSourceImpl

private fun provideUserDataSource(
    context: Context
): UserDataSource = UserDataSourceImpl(context)

fun provideDataModule(): Module = module {

    single {
        provideUserDataSource(androidContext().applicationContext)
    }

}