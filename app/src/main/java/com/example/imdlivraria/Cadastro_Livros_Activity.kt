package com.example.imdlivraria

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdlivraria.databinding.ActivityCadastroLivrosBinding

class Cadastro_Livros_Activity : AppCompatActivity() {


    private lateinit var binding: ActivityCadastroLivrosBinding

    private lateinit var bancolivros: banco
    //lateinit var adapter: ArrayAdapter<Livros>
    //lateinit var Livros: ArrayList<Livros>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroLivrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bancolivros = banco(this)
        //Livros = bancolivros.listAll()
        //adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,   Livros)
        //binding.listProdutos.adapter = adapter


        binding.Btsalvar.setOnClickListener {
            val titulolivro = binding.edTitulo.text.toString()
            val autorlivro = binding.edNome.text.toString()
            val editoralivro = binding.edDescription.text.toString()
            val isbnlivro = binding.edIsbn.text.toString().toLong()
            val descricaolivro = binding.edDescricao.text.toString()
            val urllivro = binding.edImagem.text.toString()



            if (titulolivro.isNotEmpty() && autorlivro.isNotEmpty() && editoralivro.isNotEmpty()   && descricaolivro.isNotEmpty() && urllivro.isNotEmpty()
            ){

                bancolivros.save(
                    titulolivro, autorlivro, editoralivro, isbnlivro,
                    descricaolivro, urllivro
                )
                // Limpar os campos
                binding.edTitulo.setText("")
                binding.edNome.setText("")
                binding.edDescription.setText("")
                binding.edIsbn.setText("")
                binding.edDescricao.setText("")
                binding.edImagem.setText("")

                Toast.makeText(this, "Livro salvo com sucesso", Toast.LENGTH_LONG).show()
                // Criar Intent e passar um extra
                val intent = Intent(this, ListaActivity::class.java)
                intent.putExtra("atualizacao", true)
                startActivity(intent)



            } else {
                Toast.makeText(this, "Preencha todos os campos obrigatórios!", Toast.LENGTH_LONG).show()
            }


        }
    }




}

