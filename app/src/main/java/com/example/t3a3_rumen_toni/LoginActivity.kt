package com.example.t3a3_rumen_toni

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

            val campoUsuario = binding.textoUsuario.text.toString()
            val campoContra = binding.textoContra.text.toString()

            //Verificar si el campo "textoUsuario" tiene 8 dígitos
            if (campoUsuario.matches(Regex("\\d{8}")) && campoContra.isNotEmpty()) {


                //Ahora el intent --> Comunicación entre ficheros

                val intent = Intent(this, MainActivity::class.java)

                intent.putExtra("usuario",campoUsuario)

                startActivity(intent)
            } else {

                // Mostrar un mensaje de error
                if (!campoUsuario.matches(Regex("\\d{8}"))) {
                    Toast.makeText(this, "El campo usuario debe tener 8 dígitos.", Toast.LENGTH_SHORT).show()
                }
                if (campoContra.isEmpty()) {
                    Toast.makeText(this, "El campo contraseña no puede estar vacío.", Toast.LENGTH_SHORT).show()
                }


            }





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