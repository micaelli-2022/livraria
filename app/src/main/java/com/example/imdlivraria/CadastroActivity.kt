package com.example.imdlivraria

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdlivraria.databinding.ActivityCadastroBinding
import com.example.imdlivraria.databinding.ActivityLoginBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Btcadastrese.setOnClickListener{
            var login = binding.nome.text.toString()
            var senha = binding.senha.text.toString()


            if (login.isNotEmpty() && senha.isNotEmpty()) {
                salvar_dados(login, senha)
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                // Voltar para a tela de login
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun salvar_dados(login: String, senha: String) {
        val sharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("login", login)
        editor.putString("senha", senha)
        editor.apply()
    }

}