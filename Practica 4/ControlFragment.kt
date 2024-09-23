package com.example.reproductormusica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class ControlFragment : Fragment() {

    interface ControlFragmentListener {
        fun onPlayClicked()
        fun onStopClicked()
        fun onNextClicked()
        fun onPrevClicked()
    }

    var listener: ControlFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_control, container, false)

        // Setup listeners for buttons
        view.findViewById<MaterialButton>(R.id.Play).setOnClickListener { listener?.onPlayClicked() }
        view.findViewById<MaterialButton>(R.id.Stop).setOnClickListener { listener?.onStopClicked() }
        view.findViewById<MaterialButton>(R.id.Next).setOnClickListener { listener?.onNextClicked() }
        view.findViewById<MaterialButton>(R.id.Prev).setOnClickListener { listener?.onPrevClicked() }

        return view
    }
}
