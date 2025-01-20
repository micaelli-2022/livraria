package com.example.imdlivraria

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdlivraria.databinding.ActivityCadastroBinding
import com.example.imdlivraria.databinding.ActivityDetalhamentoBinding

class DetalhamentoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhamentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityDetalhamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}