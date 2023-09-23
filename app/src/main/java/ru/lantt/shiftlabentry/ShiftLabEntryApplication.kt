package ru.lantt.shiftlabentry

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.lantt.shiftlabentry.di.provideDataModule
import ru.lantt.shiftlabentry.di.provideDomainModule
import ru.lantt.shiftlabentry.di.providePresentationModule

class ShiftLabEntryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShiftLabEntryApplication)
            modules(
                provideDataModule(),
                provideDomainModule(),
                providePresentationModule()
            )
        }
    }

}