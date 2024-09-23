// Pregunta 2: Reproductor de Musica
// De: Rodrigo Alonso Ruelas Lope
// Fecha de Creacion: 21/09/2024 - 9:00 pm
// Ultima modificacion: 22/09/2024 - 11:23 am

package com.example.reproductormusica

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    val fd by lazy {
        assets.openFd(cancionActual)
    }

    val mp by lazy {
        val m = MediaPlayer()
        m.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        fd.close()
        m.prepare()
        m
    }

    val controllers by lazy {
        listOf(R.id.Prev, R.id.Stop, R.id.Play, R.id.Next).map {
            findViewById<MaterialButton>(it)
        }
    }

    object ci {
        val Prev = 0
        val Stop = 1
        val Play = 2
        val Next = 3
    }

    val nombreCancion by lazy {
        findViewById<TextView>(R.id.nomCancion)
    }

    val canciones by lazy {
        val nombreFichero = assets.list("")?.toList() ?: listOf()
        nombreFichero.filter { it.contains(".mp3") }
    }

    var cancionesActualIndex = 0
        set(value) {
            var v = if(value == -1) {
                canciones.size-1
            } else {
                value % canciones.size
            }
            field = v
            cancionActual = canciones[v]
        }

    lateinit var cancionActual:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        controllers[ci.Play].setOnClickListener(this::playClick)
        controllers[ci.Stop].setOnClickListener(this::stopClick)
        controllers[ci.Prev].setOnClickListener(this::prevClick)
        controllers[ci.Next].setOnClickListener(this::nextClick)
        cancionActual = canciones[cancionesActualIndex]
        nombreCancion.text = cancionActual
    }

    fun playClick(view: View) {
        if (!mp.isPlaying) {
            mp.start()
            controllers[ci.Play].setIconResource(R.drawable.baseline_pause_48)
            nombreCancion.visibility = View.VISIBLE
        } else {
            mp.pause()
            controllers[ci.Play].setIconResource(R.drawable.baseline_play_arrow_48)
        }
    }

    fun stopClick(view: View) {
        if (mp.isPlaying) {
            mp.pause()
            controllers[ci.Play].setIconResource(R.drawable.baseline_play_arrow_48)
            nombreCancion.visibility = View.INVISIBLE
        }
        mp.seekTo(0)
    }

    fun nextClick(view: View) {
        cancionesActualIndex++
        refreshSong()
    }

    fun prevClick(view: View) {
        cancionesActualIndex--
        refreshSong()
    }

    fun refreshSong() {
        mp.reset()
        val fd = assets.openFd(cancionActual)
        mp.setDataSource(fd.fileDescriptor, fd.startOffset, fd.length)
        mp.prepare()
        playClick(controllers[ci.Play])
        nombreCancion.text = cancionActual
    }
}