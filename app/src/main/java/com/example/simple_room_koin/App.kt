package com.example.simple_room_koin

import android.app.Application
import com.example.simple_room_koin.injection.dbModule
import com.example.simple_room_koin.injection.repositoryModule
import com.example.simple_room_koin.injection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(
                dbModule,
                viewModelModule,
                repositoryModule
            )
        }
    }
}