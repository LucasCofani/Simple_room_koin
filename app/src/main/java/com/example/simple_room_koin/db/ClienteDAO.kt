package com.example.simple_room_koin.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.simple_room_koin.models.Cliente

@Dao
interface ClienteDAO {
    @Insert
    fun addCliente(cliente: Cliente)

    @Query("SELECT * FROM Cliente_table")
    fun getAll() : Array<Cliente>
}