package com.example.simple_room_koin.ui.cadastro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simple_room_koin.models.Cliente
import com.example.simple_room_koin.repository.LocalRepository
import kotlinx.coroutines.launch

class CadastroViewModel(private val repo : LocalRepository) : ViewModel()  {
    fun addCliente(cli : Cliente){
        viewModelScope.launch {
            repo.addCliente(cli)
        }
    }
}