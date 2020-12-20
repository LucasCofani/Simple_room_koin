package com.example.simple_room_koin.ui.cadastro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.simple_room_koin.R
import com.example.simple_room_koin.models.Cliente
import com.google.android.material.textfield.TextInputEditText
import org.koin.android.viewmodel.ext.android.viewModel


class CadastroFragment : Fragment() {
    private val vm: CadastroViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listText : ArrayList<TextInputEditText> = arrayListOf()

        val nome = view.findViewById<TextInputEditText>(R.id.ti_nome)
        val email = view.findViewById<TextInputEditText>(R.id.ti_email)
        val cep = view.findViewById<TextInputEditText>(R.id.ti_CEP)
        val bairro = view.findViewById<TextInputEditText>(R.id.ti_bairro)
        val cidade = view.findViewById<TextInputEditText>(R.id.ti_cidade)
        val estado = view.findViewById<TextInputEditText>(R.id.ti_estado)

        listText.add(nome)
        listText.add(email)
        listText.add(cep)
        listText.add(bairro)
        listText.add(cidade)
        listText.add(estado)


        view.findViewById<Button>(R.id.btn_cadastrar).setOnClickListener {
            vm.addCliente(
                Cliente(
                    nome.text.toString(),
                    email.text.toString(),
                    cep.text.toString(),
                    bairro.text.toString(),
                    cidade.text.toString(),
                    estado.text.toString()
                )
            )
            Toast.makeText(context, "Cliente adicionado!", Toast.LENGTH_SHORT).show()
            clearText(listText)
            nome.requestFocus()
        }
    }
    fun clearText(list: ArrayList<TextInputEditText>){
        list.forEach {
            it.text?.clear()
        }
    }
}