package com.example.simple_room_koin.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simple_room_koin.models.Cliente

@Database(entities = [Cliente::class], version = 1, exportSchema = false)
abstract class LocalDb : RoomDatabase(){
    abstract fun clienteDao(): ClienteDAO
}