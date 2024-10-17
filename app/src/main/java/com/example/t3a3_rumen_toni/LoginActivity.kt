package com.example.t3a3_rumen_toni

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t3a3_rumen_toni.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        //Inicializo el binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Evento al pulsar botón "Entrar"

        binding.botonEntrar.setOnClickListener {

            //Ahora el intent --> Comunicación entre ficheros

            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("usuario",binding.textoUsuario.text.toString())

            startActivity(intent)
        }

        binding.botonSalir.setOnClickListener {

            finishAffinity()


        }


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}