import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AudioPlayerActivity : AppCompatActivity() {
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var stopButton: Button
    private lateinit var audioNameTextView: TextView
    private lateinit var audioImageView: ImageView
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_player)

        playButton = findViewById(R.id.playButton)
        pauseButton = findViewById(R.id.pauseButton)
        stopButton = findViewById(R.id.stopButton)
        audioNameTextView = findViewById(R.id.audioNameTextView)
        audioImageView = findViewById(R.id.audioImageView)

        // Recuperar el nombre del audio seleccionado
        val selectedAudio = intent.getStringExtra("selectedAudio")
        audioNameTextView.text = selectedAudio

        // Cargar una imagen asociada (placeholder genérico)
        audioImageView.setImageResource(R.drawable.audio_placeholder)

        // Mapeo de nombres de audios a recursos (modificar según los recursos reales)
        val audioResource = when (selectedAudio) {
            "Audio 1" -> R.raw.audio1
            "Audio 2" -> R.raw.audio2
            "Audio 3" -> R.raw.audio3
            "Audio 4" -> R.raw.audio4
            "Audio 5" -> R.raw.audio5
            else -> R.raw.audio1 // Audio por defecto
        }

        // Inicializar el MediaPlayer con el recurso de audio seleccionado
        mediaPlayer = MediaPlayer.create(this, audioResource)

        playButton.setOnClickListener {
            mediaPlayer?.start() // Reproducir audio
        }

        pauseButton.setOnClickListener {
            mediaPlayer?.pause() // Pausar audio
        }

        stopButton.setOnClickListener {
            mediaPlayer?.stop() // Detener audio
            mediaPlayer?.prepare() // Preparar de nuevo para poder reproducir
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release() // Liberar recursos del MediaPlayer cuando se destruya la actividad
        mediaPlayer = null
    }
}
