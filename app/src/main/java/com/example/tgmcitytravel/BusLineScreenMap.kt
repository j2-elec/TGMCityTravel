package com.example.tgmcitytravel

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.text.SimpleDateFormat
import java.util.*

class BusLineScreenMap : Fragment() {
    /**
     * This is the Fragment for the Bus Line screen for Bus line 23.
     * It features a spinner to select the stations. Upon selecting a station an ETA will be displayed.
     * It also features a google map fragment with the bus stops.
     *
     * The back button navigates back to the Bus Lines screen.
     *
     * The xml layout file is: fragment_bus_line_screen_map.xml
     */
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


        // Bus Stops to be displayed on map, this first stop, ptStop is in the middle of the map,
        // this will be used to move and zoom in the camera
        val ptStop = LatLng(46.543827, 24.560349)
        googleMap.addMarker(MarkerOptions().position(ptStop).title("P-ţa Trandafirilor Stop"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ptStop,12.5f))
        val atlStop = LatLng(46.523785, 24.542121)
        googleMap.addMarker(MarkerOptions().position(atlStop).title("Autogara Transport Local Stop"))

        val budiuluiStop = LatLng(46.525158, 24.549711)
        googleMap.addMarker(MarkerOptions().position(budiuluiStop).title("Budiului Stop"))

        val cosmosStop = LatLng(46.532798, 24.559131)
        googleMap.addMarker(MarkerOptions().position(cosmosStop).title("Cosmos Stop"))

        val mihaieStop = LatLng(46.551416, 24.575047)
        googleMap.addMarker(MarkerOptions().position(mihaieStop).title("Mihai Eminescu Stop"))

        val smurdStop = LatLng(46.559524, 24.581313)
        googleMap.addMarker(MarkerOptions().position(smurdStop).title("SMURD Stop"))

        val garamStop = LatLng(46.552394,24.566958)
        googleMap.addMarker(MarkerOptions().position(garamStop).title("Gara Mică Stop"))

        val pttStop = LatLng(46.545609,24.561969)
        googleMap.addMarker(MarkerOptions().position(pttStop).title("P-ţa Teatrului Stop"))

        val ciresuluiStop = LatLng(46.535728,24.558445)
        googleMap.addMarker(MarkerOptions().position(ciresuluiStop).title("Cireşului Stop"))

        val dambptrStop = LatLng(46.531786,24.557510)
        googleMap.addMarker(MarkerOptions().position(dambptrStop).title("Dâmbul Pietros Stop"))

        val gener11Stop = LatLng(46.525616,24.550204)
        googleMap.addMarker(MarkerOptions().position(gener11Stop).title("Generala 11 Stop"))

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bus_line_screen_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
        view.findViewById<ImageView>(R.id.line_to_lines).setOnClickListener() {

            findNavController().navigate(R.id.action_busLineScreenMap_to_linesScreen)
        }
        //textView
        val spinnerResult = view.findViewById<TextView>(R.id.spinnerResult)
        //spinner
        val spinner = view.findViewById<Spinner>(R.id.planets_spinner)
        //array holding the busStations
        val array = R.array.busStation
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireActivity(),
            array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //accessing the value selected on the spinner
                val test1 = spinner.selectedItem.toString()

                //getting the time of the device and specifying a time format/
                // only interested in hour and minutes
                val format = SimpleDateFormat("mm")
                val time = format.format(Calendar.getInstance().time)


                val timeMinute = Calendar.getInstance().get(Calendar.MINUTE)

                var newTime = 0
                //last bus leaves at 10 pm
                if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 23) {
                    //knowing that the bus leaves every 30 minutes, (meaning it takes 30 minutes to do a full circle)
                    // if its past half deduct 60 else deduct 30
                    // -> to get the time until the bus arrives. between each stop there's a 5 minutes route
                    if (test1 == "Autogara Transport Local") {
                        if (time > "30") {
                            newTime = 60 - timeMinute
                            spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                        }
                        else if ( time == "00"){
                            spinnerResult.text = "Your bus should arrive in: any second"
                        }
                        else if ( time == "30"){
                            spinnerResult.text = "Your bus should arrive in: any second"
                        }
                        else {
                            newTime = 30 - timeMinute
                            spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                        }
                    } else if (test1 == "Budiului") {
                        when {
                            time == "35" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time == "05" -> {

                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time < "05" -> {
                                newTime =  5 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time < "35" -> {
                                newTime =  35 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time > "35" ->{
                                newTime =  65 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                        }
                    } else if (test1 == "Cosmos") {
                        when {
                            time == "10" -> {

                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time == "40" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time < "10" -> {
                                newTime =  10 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time < "40" ->{
                                newTime = 40 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time > "40" ->{
                                newTime = 70 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                        }
                    } else if (test1 == "P-ţa Trandafirilor") {
                        when {
                            time == "15" -> {

                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time == "45" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time < "15" ->{
                                newTime =  15 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time < "45" -> {
                                newTime =  45 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time > "45" ->{
                                newTime = 75 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                        }
                    } else if (test1 == "Mihai Eminescu") {
                        when {
                            time == "50" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time == "20" -> {

                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time < "20" -> {
                                newTime =  20 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time < "50" -> {
                                newTime =  50 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time > "50" ->{
                                newTime = 80 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                        }
                    }
                    //this is the half point of the trip
                    //but it takes 25 minutes to arrive from the starting point to here
                    // so we check if its past 25 or not
                    else if (test1 == "SMURD") {
                        when {
                            time == "25" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time == "55" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time < "25" -> {
                                newTime =  25 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time < "55" -> {
                                newTime = 55 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time > "55" -> {
                                newTime = 95 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                        }
                    } else if (test1 == "Gara Mică") {
                        when {
                            time == "00" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time == "30" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time > "30" -> {
                                newTime = 60 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time < "30" -> {
                                newTime = 30 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                        }
                    } else if (test1 == "P-ţa Teatrului") {
                        when {
                            time == "35" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time == "05" -> {

                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time < "05" -> {
                                newTime =  5 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time < "35" -> {
                                newTime =  35 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time > "35" ->{
                                newTime =  65 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                        }
                    } else if (test1 == "Cireşului") {
                        when {
                            time == "10" -> {

                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time == "40" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time < "10" -> {
                                newTime =  10 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time < "40" ->{
                                newTime = 40 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time > "40" ->{
                                newTime = 70 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                        }
                    } else if (test1 == "Dâmbul Pietros") {
                        when {
                            time == "15" -> {

                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time == "45" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time < "15" ->{
                                newTime =  15 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time < "45" -> {
                                newTime =  45 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time > "45" ->{
                                newTime = 75 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                        }
                    } else if (test1 == "Generala 11") {
                        when {
                            time == "50" -> {
                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time == "20" -> {

                                spinnerResult.text = "Your bus should arrive in: any second"
                            }
                            time < "20" -> {
                                newTime =  20 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time < "50" -> {
                                newTime =  50 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                            time > "50" ->{
                                newTime = 80 - timeMinute
                                spinnerResult.text = "Your bus should arrive in: $newTime minutes"
                            }
                        }
                    } else {
                        spinnerResult.text = "Please select a station."
                    }

                    //setting the textView to the result.

                //if outside of working ours display this :
                } else {
                    spinnerResult.text =
                        "Buses do not operate at this time. First bus leaves at 5:00"
                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}