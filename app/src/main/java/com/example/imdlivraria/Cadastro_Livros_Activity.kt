package com.example.imdlivraria

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdlivraria.databinding.ActivityCadastroLivrosBinding
import com.example.imdlivraria.databinding.ActivityLoginBinding

class Cadastro_Livros_Activity : AppCompatActivity() {





    private lateinit var binding: ActivityCadastroLivrosBinding
    private lateinit var bancolivros: banco

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroLivrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bancolivros = banco(this)

        binding.Btsalvar.setOnClickListener {
            val titulolivro = binding.edTitulo.text.toString()
            val autorlivro = binding.edNome.text.toString()
            val editoralivro = binding.edDescription.text.toString()
            val isbn = binding.edIsbn.text.toString()
            val descricaolivro = binding.edDescriO.text.toString()
            val url = binding.edImagem.text.toString()

            if (titulolivro.isNotEmpty() && autorlivro.isNotEmpty() && editoralivro.isNotEmpty() &&
                isbn.isNotEmpty() && descricaolivro.isNotEmpty() && url.isNotEmpty()
            ) {
                bancolivros.save(
                    titulolivro, autorlivro, editoralivro, isbn.toLong(),
                    descricaolivro, url
                )
                Toast.makeText(this, "Livro salvo com sucesso", Toast.LENGTH_LONG).show()


                // Limpar os campos após o cadastro
                binding.edTitulo.text.clear()
                binding.edNome.text.clear()
                binding.edDescription.text.clear()
                binding.edIsbn.text.clear()
                binding.edDescriO.text.clear()
                binding.edImagem.text.clear()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
            }
        }
    }




}

