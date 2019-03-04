package com.colvengroup.prueba.prueba

import android.graphics.Color
import com.android.volley.Request
import com.android.volley.Response
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.PolyUtil
import org.json.JSONObject

const val LATITUD = "lati"
const val LONGITUD = "longit"
const val ROUTS = "routes"
const val LEGS = "legs"
const val STEPS = "steps"
const val POLYLINE = "polyline"
const val POINTS = "points"
const val LATITUD_DESIANTION = 4.641179
const val LONGITUD_DESTINATION = -74.063477

class MapKotlinActivity : AppCompatActivity(), OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_kotlin)

        (supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment)?.let {mapa-> mapa.getMapAsync(this) }
    }


    override fun onMapReady(map: GoogleMap?) {
        val youAreHere = LatLng(currentLatitud().toDouble(), currentLongitud().toDouble())
        val latLngDestination = LatLng(LATITUD_DESIANTION, LONGITUD_DESTINATION)

        map.let {
            it?.addMarker(MarkerOptions().position(youAreHere).title("You Are Here"))
            it?.addMarker(MarkerOptions().position(latLngDestination).title("Destination"))
            it?.moveCamera(CameraUpdateFactory.newLatLng(youAreHere))
            it?.animateCamera(CameraUpdateFactory.newLatLngZoom(youAreHere, 14f))

            val path: MutableList<List<LatLng>> = ArrayList()
            val urlDirections = "https://maps.googleapis.com/maps/api/directions/json?origin="+youAreHere.latitude+","+youAreHere.longitude+"&destination="+latLngDestination.latitude+","+latLngDestination.longitude+"&key=AIzaSyBDE9OD9vT4qNRlu0l3g34g9uNYbwo16ls"
            Log.d("url",urlDirections)
            val directionsRequest = object : StringRequest(Request.Method.GET, urlDirections, Response.Listener<String> { response ->
                val jsonResponse = JSONObject(response)
                // Get routes
                val routes = jsonResponse.getJSONArray(ROUTS)
                val legs = routes.getJSONObject(0).getJSONArray(LEGS)
                val steps = legs.getJSONObject(0).getJSONArray(STEPS)
                for (i in 0 until steps.length()) {
                    val points = steps.getJSONObject(i).getJSONObject(POLYLINE).getString(POINTS)
                    path.add(PolyUtil.decode(points))
                }
                for (i in 0 until path.size) {
                    it?.addPolyline(PolylineOptions().addAll(path[i]).color(Color.RED))
                }
            }, Response.ErrorListener { _ ->
            }) {}
            val requestQueue = Volley.newRequestQueue(this)
            requestQueue.add(directionsRequest)

        }
    }
    private fun currentLatitud(): String {
        return intent?.let {
            it.getStringExtra(LATITUD) ?: ""
        } ?: ""
    }

    private fun currentLongitud(): String {
        return intent?.let {
            it.getStringExtra(LONGITUD) ?: ""
        } ?: ""
    }
}
