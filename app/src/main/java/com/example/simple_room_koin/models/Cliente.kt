package com.example.simple_room_koin.models

import android.text.Editable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Cliente_table")
data class Cliente(
    val nome: String,
    val email: String,
    val CEP: String,
    val bairro: String,
    val cidade: String,
    val estado: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)