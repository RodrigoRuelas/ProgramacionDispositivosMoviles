import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imageSpinner: Spinner
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageSpinner = findViewById(R.id.imageSpinner)
        nextButton = findViewById(R.id.nextButton)

        // Lista de nombres de imágenes (modificar según las imágenes disponibles)
        val imageNames = listOf("image1", "image2", "image3", "image4")

        // Adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, imageNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        imageSpinner.adapter = adapter

        // Recuperar selección previa del Spinner si existe
        savedInstanceState?.let {
            val savedPosition = it.getInt("spinner_position", 0)
            imageSpinner.setSelection(savedPosition)
        }

        nextButton.setOnClickListener {
            val selectedImage = imageSpinner.selectedItem.toString()

            // Navegar a la segunda actividad con la imagen seleccionada
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra("selectedImage", selectedImage)
            startActivity(intent)
        }
    }

    // Guardar la selección del Spinner al rotar la pantalla
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("spinner_position", imageSpinner.selectedItemPosition)
    }
}
