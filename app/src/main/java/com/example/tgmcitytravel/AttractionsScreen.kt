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
 * This is the fragment for the Attractions screen.
 * It has 6 Attraction options, out of which attraction1 (National Theater) is implemented.
 *
 * The back button navigates back to the Main screen.
 *
 *
 * The xml layout file is: fragment_attractions_screen.xml
 */
class AttractionsScreen : Fragment() {

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
        return inflater.inflate(R.layout.fragment_attractions_screen, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setting a click listener for the back icon
        view.findViewById<ImageView>(R.id.attractions_to_main).setOnClickListener(){
            // navigating to the main screen
            findNavController().navigate(R.id.action_attractionsScreen_to_mainScreen)
        }
        //setting a click listener for attraction 1 button
        view.findViewById<Button>(R.id.attraction1).setOnClickListener(){
            // navigating to attraction 1 screen
            findNavController().navigate(R.id.action_attractionsScreen_to_attractionMap)
        }

        //Toasts for not implemented attractions
        view.findViewById<Button>(R.id.attraction2).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.attraction3).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.attraction4).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.attraction5).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented", Toast.LENGTH_SHORT).show()
        }
        view.findViewById<Button>(R.id.attraction6).setOnClickListener(){
            Toast.makeText(activity,"Not Yet Implemented", Toast.LENGTH_SHORT).show()
        }

    }


}