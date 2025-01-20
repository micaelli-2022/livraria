package com.example.imdlivraria

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAssignedNumbers
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdlivraria.databinding.ActivityCadastroLivrosBinding
import com.example.imdlivraria.databinding.ActivityListaBinding
import com.example.imdlivraria.banco

class ListaActivity : AppCompatActivity() {


    private lateinit var binding: ActivityListaBinding
    private lateinit var bancoLivros: banco
    private lateinit var livroAdapter: LivroAdapter
    private var livrosList = ArrayList<Livros>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)



        bancoLivros = banco(this)

        // Recuperar o extra para verificar se houve atualização
        val houveAtualizacao = intent.getBooleanExtra("atualizacao", false)

        //Inicializar a lista de livros e o adapter
        livrosList = bancoLivros.listAll()
        binding.lista.layoutManager = LinearLayoutManager(this)
        livroAdapter = LivroAdapter(livrosList)
        binding.lista.adapter = livroAdapter



        if (houveAtualizacao) {
            // Limpar e atualizar a lista de livros
            livrosList.clear()
            livrosList.addAll(bancoLivros.listAll())
            livroAdapter.notifyDataSetChanged() // Atualizar o RecyclerView
        }




    }

    override fun onResume() {
        super.onResume()
        livrosList.clear()
        livrosList.addAll(bancoLivros.listAll())
        livroAdapter.notifyDataSetChanged()
    }

}


