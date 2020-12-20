package com.example.simple_room_koin.repository

import com.example.simple_room_koin.db.ClienteDAO
import com.example.simple_room_koin.models.Cliente

class LocalRepository (private val cliDAO: ClienteDAO){
    fun getAll() = cliDAO.getAll()

    fun addCliente(cli: Cliente) {
        cliDAO.addCliente(cli)
    }
}