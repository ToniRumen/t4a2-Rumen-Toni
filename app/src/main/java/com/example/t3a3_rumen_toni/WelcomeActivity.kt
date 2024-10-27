package com.example.t3a3_rumen_toni

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieAnimationView
import com.example.t3a3_rumen_toni.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        //Inicializar binding

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var imagen=findViewById<LottieAnimationView>(R.id.animacion)
        //Generar acción botón







        fun animacion(imageView: LottieAnimationView, animacion:Int){

                imageView.setAnimation(animacion)
                imageView.playAnimation()
            }






        binding.botonBienvenido.setOnClickListener(){

            //Crear intent

            val intent = Intent(this, LoginActivity::class.java)

            //Animación
            animacion(imagen,R.raw.animacion)



            // Esperar 3 segundos y luego cambiar de actividad
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(intent) }, 2000)



        }








        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }





}