import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        imageView = findViewById(R.id.imageView)
        backButton = findViewById(R.id.backButton)

        // Recuperar el nombre de la imagen seleccionada
        val selectedImage = intent.getStringExtra("selectedImage")

        // Mapeo de nombres de imágenes a recursos (modificar según los recursos reales)
        val imageResource = when (selectedImage) {
            "image1" -> R.drawable.image1
            "image2" -> R.drawable.image2
            "image3" -> R.drawable.image3
            "image4" -> R.drawable.image4
            else -> R.drawable.placeholder // Imagen por defecto si falla
        }

        // Mostrar la imagen seleccionada
        imageView.setImageResource(imageResource)

        // Volver a la actividad anterior
        backButton.setOnClickListener {
            finish() // Cierra la actividad actual y vuelve a la anterior
        }
    }
}
