package com.example.tgmcitytravel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * This is the fragment for the Bus Lines screen.
 * It has 8 line options out of which line 23 is implemented.
 *
 * It also has a back button for navigation to the Main screen.
 *
 *
 * The xml layout file is: fragment_lines_screen.xml
 */
class LinesScreen : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_lines_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // setting a click listener for the back icon
        view.findViewById<ImageView>(R.id.lines_to_main).setOnClickListener(){
            // navigating back to the main screen
            findNavController().navigate(R.id.action_linesScreen_to_mainScreen)
        }
        // setting a click listener for line 23
        view.findViewById<Button>(R.id.line_23).setOnClickListener(){
            // navigating to to line 5 screen
            findNavController().navigate(R.id.action_linesScreen_to_busLineScreenMap)
        }
        //Toasts for not implemented lines
        view.findViewById<Button>(R.id.line_44).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented",Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.line_4).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented",Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.line_14).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented",Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.line_10).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented",Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.line_6).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented",Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.line_20).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented",Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.line_32).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented",Toast.LENGTH_SHORT).show()
        }
    }


}