package com.example.simple_room_koin.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simple_room_koin.models.Cliente
import com.example.simple_room_koin.repository.LocalRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repo : LocalRepository) : ViewModel() {
    val clientes = MutableLiveData<ArrayList<Cliente>>()

    fun getAllClientes() {
        viewModelScope.launch {
            clientes.value = repo.getAll().toCollection(ArrayList())
        }
    }
}