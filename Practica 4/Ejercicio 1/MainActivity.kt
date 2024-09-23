// Pregunta 1: Galeria de Imagenes
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 21/09/2024 - 9:00 pm
// Ultima modificacion: 22/09/2024 - 11:23 am

package com.example.galeriaimagen

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.imageSpinner)
        btnNext = findViewById(R.id.btnNext)

        // Lista de nombres de imágenes
        val imageNames = arrayOf("Imagen 1", "Imagen 2", "Imagen 3")

        // Adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Restaurar la selección del spinner al rotar el dispositivo
        if (savedInstanceState != null) {
            val selectedPosition = savedInstanceState.getInt("spinnerSelection", 0)
            spinner.setSelection(selectedPosition)
        }

        // Configurar botón para pasar a la siguiente actividad
        btnNext.setOnClickListener {
            val selectedImage = spinner.selectedItemPosition
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra("selectedImage", selectedImage)
            startActivity(intent)
        }
    }

    // Guardar estado del Spinner al rotar el dispositivo
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("spinnerSelection", spinner.selectedItemPosition)
    }
}
