package com.example.t3a3_rumen_toni

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t3a3_rumen_toni.databinding.ActivityLoginBinding
import com.example.t3a3_rumen_toni.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        //Inicializar binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recuperar valor
        val numUsuarioRecibido = intent.getStringExtra("usuario")

        //Mostrar resultado
        binding.textoBienvenida.text = "Bienvenido/a \n $numUsuarioRecibido"



        //Botón "contraseña" --> A la pantalla Login


        binding.botonContrasena.setOnClickListener {

            //Intent

            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
        }





        //Botón "Salir" --> A la pantalla principal

        binding.botonSalir.setOnClickListener {

            //Intent

            val intent = Intent(this, WelcomeActivity::class.java)

            startActivity(intent)
        }

        // Le tengo que dar 40 veces al boton de iniciar
        // para que me entre aqui, o pasar por los textos.




        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}