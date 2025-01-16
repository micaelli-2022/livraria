package com.example.imdlivraria

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imdlivraria.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtEntrar.setOnClickListener{
            var login = binding.nome.text.toString()
            var senha = binding.senha.text.toString()


            if(checar_dados(login, senha) ){
                    Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    // Redirecionar para a próxima tela
                } else {
                    Toast.makeText(this, "Valores inválidos. Cadastre-se primeiro!", Toast.LENGTH_SHORT).show()
                }
            }





        binding.cadastro.setOnClickListener {
            Toast.makeText(this, "Redirecionando para cadastro", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, CadastroActivity::class.java))
        }


    }

    private fun checar_dados(login: String, senha: String): Boolean {
        val sharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString("login", null)
        val savedPassword = sharedPreferences.getString("senha", null)

        return login == savedUsername && senha == savedPassword
    }
}