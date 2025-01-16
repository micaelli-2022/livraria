package com.example.imdlivraria

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdlivraria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            //enableEdgeToEdge()
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)


            binding.btcadastro.setOnClickListener {
                startActivity(Intent(this, Cadastro_Livros_Activity::class.java))

            }


            binding.btlistar.setOnClickListener {
                startActivity(Intent(this, ListaActivity::class.java))

            }

            binding.btexcluir.setOnClickListener {
                startActivity(Intent(this, ExcluirActivity2::class.java))

            }


        }

}