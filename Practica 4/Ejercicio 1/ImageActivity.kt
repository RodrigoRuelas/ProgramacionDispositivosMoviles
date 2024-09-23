package com.example.galeriaimagen

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen)

        imageView = findViewById(R.id.imageView)
        btnBack = findViewById(R.id.btnBack)

        // Obtener la imagen seleccionada de la actividad anterior
        val selectedImage = intent.getIntExtra("selectedImage", 0)

        // Comprobar y cargar la imagen correspondiente
        val imageResId = when (selectedImage) {
            0 -> R.drawable.imagen1 // Asegúrate de que imagen1.png/jpg está en drawable
            1 -> R.drawable.imagen2 // Asegúrate de que imagen2.png/jpg está en drawable
            else -> R.drawable.imagen1 // Default a imagen1 si el índice es inválido
        }

        // Establecer el recurso de imagen en el ImageView
        imageView.setImageResource(imageResId)

        // Configurar botón para volver a la actividad anterior
        btnBack.setOnClickListener {
            finish()
        }
    }
}
