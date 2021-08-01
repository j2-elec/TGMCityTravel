package com.example.tgmcitytravel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController



/**
 * This is the fragment for the Help screen. It contains information about the purpose of the app,
 * and how the app works.
 * It also contains contact information.
 *
 * It has a back button to navigate back to the Main Screen.
 *
 * The xml layout file is: fragment_help_screen.xml
 */
class HelpScreen : Fragment() {



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
        return inflater.inflate(R.layout.fragment_help_screen, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // setting listener for the back icon
        view.findViewById<ImageView>(R.id.help_to_main).setOnClickListener(){
            // navigating to the main screen
            findNavController().navigate(R.id.action_helpScreen_to_mainScreen)
        }

    }


}