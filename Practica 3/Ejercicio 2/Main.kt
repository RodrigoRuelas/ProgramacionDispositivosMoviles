import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var audioSpinner: Spinner
    private lateinit var selectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioSpinner = findViewById(R.id.audioSpinner)
        selectButton = findViewById(R.id.selectButton)

        // Lista de nombres de audios (modificar según los audios disponibles)
        val audioNames = listOf("Audio 1", "Audio 2", "Audio 3", "Audio 4", "Audio 5")

        // Adaptador para el Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, audioNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        audioSpinner.adapter = adapter

        selectButton.setOnClickListener {
            val selectedAudio = audioSpinner.selectedItem.toString()

            // Navegar a la segunda actividad con el audio seleccionado
            val intent = Intent(this, AudioPlayerActivity::class.java)
            intent.putExtra("selectedAudio", selectedAudio)
            startActivity(intent)
        }
    }
}
