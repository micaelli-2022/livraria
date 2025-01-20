package com.example.imdlivraria

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdlivraria.databinding.ActivityExcluir2Binding

class ExcluirActivity2 : AppCompatActivity() {


    private lateinit var binding: ActivityExcluir2Binding
    private lateinit var bancolivros: banco

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityExcluir2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        bancolivros = banco(this)

        binding.Btexcluir.setOnClickListener {

           /* val isbn = binding.edIsbn

            if (isbn.isNotEmpty()) {

                val exclusao = bancolivros.delete(isbn)

                if (exclusao) {

                    Toast.makeText(this, "Livro excluído com sucesso!", Toast.LENGTH_LONG).show()

                    // Retorna à tela principal
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()

                } else {
                    //  não encontre o livro
                    Toast.makeText(this, "Livro não encontrado!", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Por favor, insira o ISBN!", Toast.LENGTH_SHORT).show()
            }*/
        }
    }






}