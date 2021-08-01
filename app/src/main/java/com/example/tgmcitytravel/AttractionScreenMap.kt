package com.example.tgmcitytravel

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

/**
 * This is the Fragment for the Attraction 1 (National Theater)
 * It has a description of the attraction, with an image sourced from the official site of the theater (https://teatrunational.ro/the-theater-lr/?lg=en)
 *
 * It  shows the Bus stops at the location, the textview is click-able and takes the user to the Bus Line screen (Line 23).
 *
 * It also features a map with the location of the attraction and a close-by bus stop.
 *
 *
 * The back button navigates back to the Attractions screen.
 *
 * The xml layout file is: fragment_attraction_screen_map.xml
 *
 */

class AttractionScreenMap : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val natTheatre = LatLng(46.546247,24.560718)
        googleMap.addMarker(MarkerOptions().position(natTheatre).title("National Theatre"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(natTheatre,16f))
        val pttStop = LatLng(46.545609,24.561969)
        googleMap.addMarker(MarkerOptions().position(pttStop).title("P-ţa Teatrului Stop"))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_attraction_screen_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        view.findViewById<ImageView>(R.id.attraction_to_attractions).setOnClickListener(){
            //navigating to the lines screen
            findNavController().navigate(R.id.action_attractionMap_to_attractionsScreen)
        }
        view.findViewById<TextView>(R.id.attr_busline).setOnClickListener(){
            //navigating to the lines screen
            findNavController().navigate(R.id.action_attractionMap_to_busLineScreenMap)
        }
    }
}