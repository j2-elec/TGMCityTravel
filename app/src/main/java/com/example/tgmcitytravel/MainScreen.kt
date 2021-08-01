package com.example.tgmcitytravel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

/**
 * This is the Main Screen fragment of the application.
 *
 * It serves to navigate to each of the segments of the application: Bus Lines, Attractions and Help.
 *
 *
 * The xml layout file is: fragment_main_screen.xml
 */
class MainScreen : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // setting listener for the bus icon
        view.findViewById<ImageView>(R.id.to_bustlines).setOnClickListener {
            // navigating to the bus lines screen
            findNavController().navigate(R.id.action_mainScreen_to_linesScreen)
        }
        //setting listener for the attraction icon
        view.findViewById<ImageView>(R.id.to_attractions).setOnClickListener {
            // navigating to the attractions screen
            findNavController().navigate(R.id.action_mainScreen_to_attractionsScreen)
        }
        // setting listener for the help icon
        view.findViewById<ImageView>(R.id.to_help).setOnClickListener(){
            // navigating to the help screen
            findNavController().navigate(R.id.action_mainScreen_to_helpScreen)
        }
    }
}