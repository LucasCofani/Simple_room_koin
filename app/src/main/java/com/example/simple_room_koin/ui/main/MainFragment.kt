package com.example.simple_room_koin.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_room_koin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    private val vm: MainViewModel by viewModel()
    private val adapter =  MainAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var rvMain: RecyclerView = view.findViewById(R.id.rv_cliente)
        rvMain.layoutManager = LinearLayoutManager(context)
        rvMain.setHasFixedSize(true)
        rvMain.adapter = adapter

        vm.clientes.observe(viewLifecycleOwner, {
            adapter.updateCliente(it)
        })

        vm.getAllClientes()

        view.findViewById<FloatingActionButton>(R.id.fa_add).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_cadastroFragment)
        }

    }

}