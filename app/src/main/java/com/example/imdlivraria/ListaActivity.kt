package com.example.imdlivraria

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imdlivraria.databinding.ActivityCadastroLivrosBinding
import com.example.imdlivraria.databinding.ActivityListaBinding
import com.example.imdlivraria.banco

class ListaActivity : AppCompatActivity() {


    private lateinit var binding: ActivityListaBinding
    private lateinit var bancolivros: banco
   // private lateinit var livroAdapter: LivroAdapter
    //private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    fun initRecyclerView() {
        val recyclerView = binding.lista

        // Recupera os livros do banco de dados
        val livros = bancolivros.listAll()

        // Inicializa o Adapter com os dados do banco de dados
        val livroAdapter = LivroAdapter(livros)

        // Configura o RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = livroAdapter

        // Adiciona a linha de separação entre os itens da lista
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)
    }




}