package com.example.t3a3_rumen_toni

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t3a3_rumen_toni.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        //Inicializo el binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var textoUsuarioCorrecto = false
        var contraUsuarioCorrecto = false


        binding.textoUsuario.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->

            //Si pierde el foco
            if (!hasFocus) {

                if (!(binding.textoUsuario.text.toString().matches(Regex("\\d{8}[a-zA-Z]")))) {

                        Snackbar.make(binding.root, "El campo debe tener 8 números, seguido de una letra.", Snackbar.LENGTH_SHORT)
                            .setAnchorView(binding.layoutUsuario)
                            .show()
                    textoUsuarioCorrecto = false;

                } else {
                    textoUsuarioCorrecto = true;
                }





            }

        }

        binding.textoContra.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->

            if (!hasFocus) {

                if ((binding.textoContra.text.toString()).isEmpty()) {

                    Snackbar.make(binding.root, "La contraseña no puede estar vacía.", Snackbar.LENGTH_SHORT)
                        .setAnchorView(binding.layoutContra)
                        .show()
                    contraUsuarioCorrecto = false

                } else {
                    contraUsuarioCorrecto = true
                }

            }

        }

            binding.botonEntrar.setOnClickListener(){

                var campoUsuario = binding.textoUsuario.text.toString()

                if (textoUsuarioCorrecto && contraUsuarioCorrecto) {


                    //Ahora el intent --> Comunicación entre ficheros

                    val intent = Intent(this, MainActivity::class.java)

                    intent.putExtra("usuario",campoUsuario)

                    startActivity(intent)


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