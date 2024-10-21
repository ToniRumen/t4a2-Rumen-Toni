package com.example.t3a3_rumen_toni

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t3a3_rumen_toni.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        //Inicializar binding

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Generar acción botón

        binding.botonBienvenido.setOnClickListener(){

            //Crear intent

            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)

        }





        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }





}