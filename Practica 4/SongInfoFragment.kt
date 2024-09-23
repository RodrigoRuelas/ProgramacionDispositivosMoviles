package com.example.reproductormusica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SongInfoFragment : Fragment() {

    private lateinit var songNameTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_song_info, container, false)
        songNameTextView = view.findViewById(R.id.nomCancion)
        return view
    }

    fun updateSongName(songName: String) {
        songNameTextView.text = songName
    }
}
