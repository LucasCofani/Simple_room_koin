package com.example.simple_room_koin.injection

import android.app.Application
import androidx.room.Room
import com.example.simple_room_koin.db.ClienteDAO
import com.example.simple_room_koin.db.LocalDb
import com.example.simple_room_koin.repository.LocalRepository
import com.example.simple_room_koin.ui.cadastro.CadastroViewModel
import com.example.simple_room_koin.ui.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    fun provideDatabase(application: Application): LocalDb {
        return Room.databaseBuilder(application, LocalDb::class.java, "ClienteDb")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: LocalDb): ClienteDAO {
        return database.clienteDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }

}

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
    viewModel {
        CadastroViewModel(get())
    }
}

val repositoryModule = module {
    fun provideUserRepository(dao: ClienteDAO): LocalRepository {
        return LocalRepository(dao)
    }
    single { provideUserRepository(get()) }
}